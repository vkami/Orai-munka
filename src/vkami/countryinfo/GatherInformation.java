package vkami.countryinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class GatherInformation {

    private ArrayList<Country> orszagok;

    public GatherInformation(String inFile) {

        ArrayList<Country> orszagok=new ArrayList<>();

        File file=new File(inFile);
        try {
            BufferedReader reader=new BufferedReader( new FileReader(file));

            int count=0;
            String line;

            while ( (line=reader.readLine())!=null ) {
                if (count++!=0) {
                    orszagok.add(new Country(line.split(",")));
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Fájl nem található");
            e.printStackTrace();
        }

        this.orszagok=orszagok;
    }

    public ArrayList<String> getCountryNames(){

        ArrayList<String> names=new ArrayList<>();

        for(Country act:orszagok) names.add(act.getCountry());
        return names;
    }

    public ArrayList<Country> getOrszagok() {
        return orszagok;
    }
}
