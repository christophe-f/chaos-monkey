package ninja.spring.chaos.beerservice.loader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenBeer implements Serializable {
    private String id;
    private String name;
    private String catName;
    private String styleName;
    private Double abv;
    private Integer ibu;
    private Integer srm;
    private String country;
    private String nameBreweries;
}



