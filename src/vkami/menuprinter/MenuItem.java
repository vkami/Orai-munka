package vkami.menuprinter;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private String name;
    private List<MenuItem> subs=new ArrayList<>();

    public MenuItem(String name){
        this.name=name;
    }

    public MenuItem(String name, MenuItem ... subs){
        this.name=name;
        for (MenuItem act:subs) this.subs.add(act);
    }

    public void write(){

        System.out.println( "- " + name );
        char letter='a';

        for(MenuItem act:subs)
            act.write("\t", letter++);
    }

    public void write(String tabs, char letter){

        if ( tabs.length()==1 ) {
            System.out.println( tabs + letter + "./ " + name);
        } else if ( tabs.length()>1 ) {
            System.out.println( tabs + "* " + name);
        }

        tabs+="\t";
        for(MenuItem act:subs)
            act.write(tabs, letter);
    }



}
