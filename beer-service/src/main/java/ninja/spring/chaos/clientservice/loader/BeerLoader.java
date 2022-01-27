package ninja.spring.chaos.clientservice.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ninja.spring.chaos.clientservice.beer.Beer;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;


@Component
public class BeerLoader {
    private final ReactiveRedisConnectionFactory factory;
    private final ReactiveRedisOperations<String, Beer> beerOps;
    private final ObjectMapper objectMapper;
    private static final Logger logger = Logger.getLogger(BeerLoader.class.getName());

    public BeerLoader(ReactiveRedisConnectionFactory factory,
                      ReactiveRedisOperations<String, Beer> beerOps,
                      ObjectMapper objectMapper) {
        this.factory = factory;
        this.beerOps = beerOps;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadData() {
        logger.info("Importing beer list");

        // Flush anything that was previously in Redis
        factory.getReactiveConnection().serverCommands().flushAll().subscribe();

        // Insert beer list in Redis from the beer database (Json format)
        ClassLoader classLoader = getClass().getClassLoader();
        try (Reader in = new InputStreamReader(Objects.requireNonNull(classLoader.getResource("open-beer-database.json")).openStream(), StandardCharsets.UTF_8)) {
            List<OpenDatabase> records = objectMapper.readValue(in, new TypeReference<List<OpenDatabase>>() {
            });

            for (OpenDatabase record : records) {
                OpenBeer openBeer = record.getFields();
                beerOps.opsForValue().set(openBeer.getId(), new Beer(
                        openBeer.getId(),
                        openBeer.getName(),
                        openBeer.getCatName(),
                        openBeer.getStyleName(),
                        openBeer.getAbv(),
                        openBeer.getIbu(),
                        openBeer.getSrm(),
                        openBeer.getCountry(),
                        openBeer.getNameBreweries())).subscribe();
            }
            logger.info("Import complete");
        } catch (Exception e) {
            logger.info("Could not import the beer list");
        }
    }
}