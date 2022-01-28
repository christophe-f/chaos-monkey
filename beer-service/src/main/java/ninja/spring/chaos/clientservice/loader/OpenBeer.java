package ninja.spring.chaos.clientservice.loader;

import java.io.Serializable;
import java.util.Objects;

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

    public OpenBeer() {
    }

    public OpenBeer(String id, String name, String catName, String styleName, Double abv, Integer ibu, Integer srm, String country, String nameBreweries) {
        this.id = id;
        this.name = name;
        this.catName = catName;
        this.styleName = styleName;
        this.abv = abv;
        this.ibu = ibu;
        this.srm = srm;
        this.country = country;
        this.nameBreweries = nameBreweries;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Integer getIbu() {
        return ibu;
    }

    public void setIbu(Integer ibu) {
        this.ibu = ibu;
    }

    public Integer getSrm() {
        return srm;
    }

    public void setSrm(Integer srm) {
        this.srm = srm;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNameBreweries() {
        return nameBreweries;
    }

    public void setNameBreweries(String nameBreweries) {
        this.nameBreweries = nameBreweries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenBeer openBeer = (OpenBeer) o;
        return Objects.equals(id, openBeer.id) && Objects.equals(name, openBeer.name) && Objects.equals(catName, openBeer.catName) && Objects.equals(styleName, openBeer.styleName) && Objects.equals(abv, openBeer.abv) && Objects.equals(ibu, openBeer.ibu) && Objects.equals(srm, openBeer.srm) && Objects.equals(country, openBeer.country) && Objects.equals(nameBreweries, openBeer.nameBreweries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, catName, styleName, abv, ibu, srm, country, nameBreweries);
    }

    @Override
    public String toString() {
        return "OpenBeer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", catName='" + catName + '\'' +
                ", styleName='" + styleName + '\'' +
                ", abv=" + abv +
                ", ibu=" + ibu +
                ", srm=" + srm +
                ", country='" + country + '\'' +
                ", nameBreweries='" + nameBreweries + '\'' +
                '}';
    }
}



