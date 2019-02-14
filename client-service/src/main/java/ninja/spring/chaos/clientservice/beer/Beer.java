package ninja.spring.chaos.clientservice.beer;

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
    private String categoryName;
    private String styleName;
    private Double abv;
    private Integer ibu;
    private Integer srm;
    private String country;
    private String breweryName;
}