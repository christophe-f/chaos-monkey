package ninja.spring.chaos.beerservice.beer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beer {
    private String id;
    private String name;
//    private String country;
//    private String ibu;
//    private String breweryName;
//    private String ratings;
}
