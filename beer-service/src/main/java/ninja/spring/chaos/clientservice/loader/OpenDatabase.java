package ninja.spring.chaos.clientservice.loader;

import java.io.Serializable;
import java.util.Objects;

public class OpenDatabase implements Serializable {
    private OpenBeer fields;

    public OpenDatabase() {
    }

    public OpenDatabase(OpenBeer fields) {
        this.fields = fields;
    }

    public OpenBeer getFields() {
        return fields;
    }

    public void setFields(OpenBeer fields) {
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenDatabase that = (OpenDatabase) o;
        return Objects.equals(fields, that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields);
    }

    @Override
    public String toString() {
        return "OpenDatabase{" +
                "fields=" + fields +
                '}';
    }
}

