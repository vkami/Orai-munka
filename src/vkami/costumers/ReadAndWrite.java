package vkami.costumers;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadAndWrite {

    public static void main(String[] args) {

        List<Costumer> costumers=new ArrayList<>();
        String head="";

        File file=new File("src\\vkami\\costumers\\ugyfelek.csv");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int count=0;
            String line;

            while ( (line=reader.readLine())!=null ) {
                if ( count++==0 ) {

                    head=line;
                } else {
                    String[] data = line.split(",");
                    costumers.add(new Costumer(data));
                }
            }

            reader.close();

        } catch (Exception e) {
            System.out.println( "Fájl nem található..." );
        }


        Collections.sort(costumers, new OrederByAccStart() );
        writeFile("szamlanyitas.csv", costumers, head);

        Collections.sort(costumers, new OrederByName() );
        writeFile("nevek.csv", costumers, head);

        Collections.sort(costumers, new OrederByMoney() );
        writeFile("penzosszegek.csv", costumers, head);

    }

    private static void writeFile(String filename, List costumers, String head) {

        File file=new File("src\\vkami\\costumers\\" + filename);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write(head + "\n");

            for (int n=0; n<costumers.size(); n++) {
                writer.write(costumers.get(n).toString() + "\n");
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Hiba történt...");
        }
    }
}
