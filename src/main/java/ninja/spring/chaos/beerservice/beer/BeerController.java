package ninja.spring.chaos.beerservice.beer;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

//    @GetMapping("/beers/{id}")
//    public Flux<Beer> beerById(@PathVariable String id) {
//        return beerOps.keys(id)
//                .flatMap(beerOps.opsForValue()::get);
//    }

    @GetMapping("/beers/{id}")
    public ResponseEntity<Beer> beerById(@PathVariable String id) {
        return ResponseEntity.ok(new Beer());

    }
}
