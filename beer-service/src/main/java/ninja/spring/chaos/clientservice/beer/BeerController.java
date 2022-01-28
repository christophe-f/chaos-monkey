package ninja.spring.chaos.clientservice.beer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/beers")
    public Mono<Beer> all() {
        return beerService.getBeers();
    }

    @GetMapping("/beers/{beerId}")
    public Mono<Beer> beerById(@PathVariable String beerId) {
        return beerService.getBeerById(beerId);
    }
}
