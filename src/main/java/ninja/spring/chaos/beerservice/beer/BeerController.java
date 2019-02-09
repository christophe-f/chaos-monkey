package ninja.spring.chaos.beerservice.beer;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class BeerController {
    private final ReactiveRedisOperations<String, Beer> beerOps;

    public BeerController(ReactiveRedisOperations<String, Beer> beerOps) {
        this.beerOps = beerOps;
    }

    @GetMapping("/beers")
    public Flux<Beer> all() {
        return beerOps.keys("*")
                .flatMap(beerOps.opsForValue()::get);
    }
}
