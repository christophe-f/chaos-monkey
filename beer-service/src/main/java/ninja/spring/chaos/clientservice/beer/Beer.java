package ninja.spring.chaos.clientservice.beer;

import java.util.Objects;

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

    public Beer() {
    }

    public Beer(String id, String name, String categoryName, String styleName, Double abv, Integer ibu, Integer srm, String country, String breweryName) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.styleName = styleName;
        this.abv = abv;
        this.ibu = ibu;
        this.srm = srm;
        this.country = country;
        this.breweryName = breweryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return Objects.equals(id, beer.id) && Objects.equals(name, beer.name) && Objects.equals(categoryName, beer.categoryName) && Objects.equals(styleName, beer.styleName) && Objects.equals(abv, beer.abv) && Objects.equals(ibu, beer.ibu) && Objects.equals(srm, beer.srm) && Objects.equals(country, beer.country) && Objects.equals(breweryName, beer.breweryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categoryName, styleName, abv, ibu, srm, country, breweryName);
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", styleName='" + styleName + '\'' +
                ", abv=" + abv +
                ", ibu=" + ibu +
                ", srm=" + srm +
                ", country='" + country + '\'' +
                ", breweryName='" + breweryName + '\'' +
                '}';
    }
}