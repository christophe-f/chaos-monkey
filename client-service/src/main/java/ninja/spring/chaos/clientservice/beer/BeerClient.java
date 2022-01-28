package ninja.spring.chaos.clientservice.beer;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class BeerClient {
    private final WebClient client;

    public BeerClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://beer-service").build();
    }

    public Mono<Beer> getBeers() {
        return this.client.get().uri("/beers").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Beer.class);
    }
}
