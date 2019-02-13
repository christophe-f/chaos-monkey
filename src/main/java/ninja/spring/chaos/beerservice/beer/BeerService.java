package ninja.spring.chaos.beerservice.beer;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
class BeerService {

    private final ReactiveRedisOperations<String, Beer> beerOps;

    public BeerService(ReactiveRedisOperations<String, Beer> beerOps) {
        this.beerOps = beerOps;
    }

    Flux<Beer> getBeers() {
        return beerOps.keys("*")
                .flatMap(beerOps.opsForValue()::get);
    }

    Flux<Beer> getBeerById(String beerId) {
        return beerOps.keys(beerId)
                .flatMap(beerOps.opsForValue()::get);
    }
}
