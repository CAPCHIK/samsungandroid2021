package ru.capchik.samsungandroid2021.iep0221.l211013;

public class Person {

    private static int lastId;

    private static double soShortPeoplePoint = 1.2;
    private static double shortPeoplePoint = 1.5;


    private String name;
    private double heightInMeter;
    private final int id;

    public Person(String name){
        id = lastId++;
        if (name == null || name.length() == 0) {
            name = "DEFAULT NAME #" + id;
        }
        this.name = name;
    }

    public void setName(String name) {
        if(name == null || name.length() == 0) {
            return;
        }
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getHeightInMeter() {
        return heightInMeter;
    }

    public void setHeightInMeter(double heightInMeter) {
        this.heightInMeter = heightInMeter;
    }

    public static void setHeightPoints(
            double soShortPeoplePoint,
            double shortPeoplePoint
    ) {
        Person.soShortPeoplePoint = soShortPeoplePoint;
        Person.shortPeoplePoint = shortPeoplePoint;
    }

    public String getPrettyHeight() {
        if (this.heightInMeter < Person.soShortPeoplePoint) {
            return "Стремянка";
        }
        if (heightInMeter < shortPeoplePoint) {
            return "Полторашка";
        }
        return "Вроде норм";
    }

}
