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
            act.write(1, letter++);
    }


    public void write(int szint, char letter){

        if ( szint==1 ) {
            System.out.println( letter + "./ " + name);
        } else if ( szint>1 ) {
            System.out.println( "* " + name);
        }

        szint++;
        for(MenuItem act:subs)
            act.write(szint, letter);

    }

}
