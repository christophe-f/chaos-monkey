package ninja.spring.chaos.beerservice.loader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenDatabase implements Serializable {
    private OpenBeer fields;
}



