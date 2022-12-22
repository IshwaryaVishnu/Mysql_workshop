package se.lexicon.model;

public class City {

    private Integer id;
    private String name;
    private String countryCode;
    private String district;
    private double population;

    public City(Integer id, String name, String district,String countryCode,double population) {
        this.id = id;
        this.district = district;
        this.countryCode = countryCode;
        this.population = population;
    }

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getPopulation() {
        return  population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

       @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}

