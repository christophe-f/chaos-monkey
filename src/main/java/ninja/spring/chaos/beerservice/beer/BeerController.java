package ninja.spring.chaos.beerservice.beer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/beers")
    public Flux<Beer> all() {
        return beerService.getBeers();
    }

    @GetMapping("/beers/{id}")
    public Flux<Beer> beerById(@PathVariable String beerId) {
        return beerService.getBeerById(beerId);
    }
}
