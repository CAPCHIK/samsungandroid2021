package ru.capchik.samsungandroid2021.iep0321.l211014;

public class Person {
    private static int lastId;
    private static int notSoSmartBorder = 100;
    private static int normalBorder = 120;

    private final int id;
    private String name;
    private short iq;

    public Person(String name) {
        id = lastId++;
        if (name == null || name.length() == 0) {
            name = "DEFAULT NAME";
        }
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public static void setSmartBorders(
            int notSoSmartBorder,
            int normalBorder){
        Person.notSoSmartBorder = notSoSmartBorder;
        Person.normalBorder = normalBorder;
    }


    public void setName(String name) {
        if (name == null || name.length() == 0) {
            return;
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addIq(short newIq) {
        if (newIq < 0) {
            newIq = 0;
        }
        //...
        iq += newIq;
    }

    public void substractIq(short iqToSubstract) {
        if (iqToSubstract < 0) {
            iqToSubstract = 0;
        }
        if (iqToSubstract > iq) {
            iqToSubstract = iq;
        }
        iq -= iqToSubstract;
    }

    public short getIq(){
        return iq;
    }

    public String getSmartCategory() {
        if (iq < notSoSmartBorder) {
            return "Not so smart";
        }
        if (iq < normalBorder) {
            return "Normal";
        }
        return "Smart";
    }

}
