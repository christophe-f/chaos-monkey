package ninja.spring.chaos.beerservice.beer;

import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class BeerLoader {
    private final ReactiveRedisConnectionFactory factory;
    private final ReactiveRedisOperations<String, Beer> beerOps;

    public BeerLoader(ReactiveRedisConnectionFactory factory, ReactiveRedisOperations<String, Beer> beerOps) {
        this.factory = factory;
        this.beerOps = beerOps;
    }

    @PostConstruct
    public void loadData() {
        factory.getReactiveConnection().serverCommands().flushAll().thenMany(
                Flux.just("Jet Black Redis", "Darth Redis", "Black Alert Redis")
                        .map(name -> new Beer(UUID.randomUUID().toString(), name))
                        .flatMap(beer -> beerOps.opsForValue().set(beer.getId(), beer)))
                .thenMany(beerOps.keys("*")
                        .flatMap(beerOps.opsForValue()::get))
                .subscribe(System.out::println);
    }
}