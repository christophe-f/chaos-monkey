package ninja.spring.chaos.clientservice.loader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenDatabase implements Serializable {
    private OpenBeer fields;
}



