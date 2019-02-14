package ninja.spring.chaos.clientservice.beer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@RestController
public class BeerController {

    private WebClient.Builder webClientBuilder;
    private final Beer fallbackBeer = Beer.builder()
            .name("Steam Whistle Pilsner")
            .breweryName("Steam Whistle Brewing")
            .ibu(21)
            .abv(5.0)
            .styleName("Premium Lager")
            .build();


    public BeerController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/beers")
    public Mono all() {
        Flux beerFlux = webClientBuilder.build().get()
                .uri("http://beer-service/beers")
                .retrieve()
                .bodyToFlux(Beer.class);

        return beerFlux.collectList();
//                .onErrorReturn(Collections.singletonList(fallbackBeer));
    }

    @GetMapping("/beers/{beerId}")
    public Mono<Beer> beerById(@PathVariable String beerId) {
        return webClientBuilder.build().get()
                .uri("http://beer-service/beers/{beerId}", beerId)
                .retrieve()
                .bodyToMono(Beer.class);
//                .onErrorReturn(fallbackBeer);
    }
}
