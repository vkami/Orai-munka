package vkami.countryinfo;

public class Country {

    private String country;
    private String capital;
    private String population;
    private String image;

    public Country(String[] in){

        country=in[0];
        capital=in[1];
        population=in[2];
        image=in[3];
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", image='" + image + '\'' +
                '}';
    }
}
