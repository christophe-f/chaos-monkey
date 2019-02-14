package ninja.spring.chaos.clientservice.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ninja.spring.chaos.clientservice.beer.Beer;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class BeerLoader {
    private final ReactiveRedisConnectionFactory factory;
    private final ReactiveRedisOperations<String, Beer> beerOps;
    private ObjectMapper objectMapper;

    public BeerLoader(ReactiveRedisConnectionFactory factory, ReactiveRedisOperations<String, Beer> beerOps, ObjectMapper objectMapper) {
        this.factory = factory;
        this.beerOps = beerOps;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadData() {
        log.info("Importing beer list");

        // Flush anything that was previously in Redis
        factory.getReactiveConnection().serverCommands().flushAll().subscribe();

        // Insert beer list in Redis from the beer database (Json format)
        ClassLoader classLoader = getClass().getClassLoader();
        try (Reader in = new InputStreamReader(Objects.requireNonNull(classLoader.getResource("open-beer-database.json")).openStream(), "UTF-8")) {
            List<OpenDatabase> records = objectMapper.readValue(in, new TypeReference<List<OpenDatabase>>() {
            });

            for (OpenDatabase record : records) {
                OpenBeer openBeer = record.getFields();
                beerOps.opsForValue().set(openBeer.getId(), Beer.builder()
                        .id(openBeer.getId())
                        .name(openBeer.getName())
                        .categoryName(openBeer.getCatName())
                        .styleName(openBeer.getStyleName())
                        .abv(openBeer.getAbv())
                        .ibu(openBeer.getIbu())
                        .srm(openBeer.getSrm())
                        .country(openBeer.getCountry())
                        .breweryName(openBeer.getNameBreweries())
                        .build()).subscribe();
            }
            log.info("Import complete");
        } catch (Exception e) {
            log.error("Could not import the beer list", e);
        }
    }
}