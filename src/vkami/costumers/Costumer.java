package vkami.costumers;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Costumer {

    private String name;
    private String motherName;
    private String dayOfBirth;
    private String placeOfBirth;
    private String accStart;
    private String id;
    private int balance;
    private int deposit;

    public Costumer(String[] data) {
        name = data[0];
        motherName = data[1];
        dayOfBirth = data[2];
        placeOfBirth = data[3];
        accStart = data[4];
        id = data[5];
        balance = Integer.parseInt(data[6]);
        deposit = Integer.parseInt(data[7]);
    }

    @Override
    public String toString() {
        return  name + "," +
                motherName + "," +
                dayOfBirth + "," +
                placeOfBirth + "," +
                accStart + "," +
                id + "," +
                balance + "," +
                deposit;
    }

    public String getName() {
        return name;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getAccStart() {
        return accStart;
    }

    public int getBalance() {
        return balance;
    }

    public int getDeposit() {
        return deposit;
    }
}

class OrederByName<T extends Costumer> implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        T c1=(T)o1;
        T c2=(T)o2;

        String s1=c1.getName() + c1.getMotherName();
        String s2=c2.getName() + c2.getMotherName();

        Set<String> comp=new TreeSet<>();
        comp.add(s1);
        comp.add(s2);

        String first=comp.iterator().next();

        if ( first==s1 ) {
            return -1;
        } else if ( first==s2 ) {
            return 1;
        } else {
            return 0;
        }
    }
}

class OrederByAccStart<T extends Costumer> implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        T c1=(T)o1;
        T c2=(T)o2;

        String d1=c1.getAccStart();
        String d2=c2.getAccStart();

        Set<String> comp=new TreeSet<>();
        comp.add(d1);
        comp.add(d2);

        String first=comp.iterator().next();

        if ( first==d1 ) {
            return -1;
        } else if ( first==d2 ) {
            return 1;
        } else {
            return 0;
        }
    }
}

class OrederByMoney<T extends Costumer> implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        T c1=(T)o1;
        T c2=(T)o2;

        int n1=c1.getBalance() + c1.getDeposit();
        int n2=c2.getBalance() + c2.getDeposit();

        Set<Integer> comp=new TreeSet<>();
        comp.add(n1);
        comp.add(n2);

        int first=comp.iterator().next();

        if ( first==n1 ) {
            return -1;
        } else if ( first==n2 ) {
            return 1;
        } else {
            return 0;
        }
    }
}