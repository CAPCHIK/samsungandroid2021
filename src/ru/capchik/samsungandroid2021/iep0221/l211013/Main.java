package ru.capchik.samsungandroid2021.iep0221.l211013;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Rectangle r = new Rectangle(2, 5);
        showInfo(r);
        formatRectToPalka(r, 6);
        showInfo(r);
        Square s = new Square(4);
        showInfo(s);
        s.setSize(16);
        s.setWidth(9);
        showInfo(s);
        Rectangle someRec = s;
        formatRectToPalka(someRec, 7);
        showInfo(someRec);

    }

    private static void formatRectToPalka(
            Rectangle r,
            int baseSize) {
        r.setWidth(baseSize);
        r.setHeight(baseSize * 2);
    }

    private static void showInfo(Rectangle r) {
        System.out.println(r.getWidth() +
                " x "
                + r.getHeight());
    }


    private static void workWithAlyansHero() {
        Hero hero = new Hero("Рабочий");
        AlyansHero hero2 = new AlyansHero("Крестьянин");
        Hero[] heroes = {hero, hero2};
        for (Hero h: heroes) {
            System.out.println(h.getPhrase());
        }
    }

    private static void workWithPrivateConstructor() {
//        Hero hero1 = new Hero("Альянс");
//        Hero hero1 = Hero.createAlyansHero("");
//        Hero hero2 = Hero.createNezitHero("");
//        Hero hero3 = Hero.createOrdaHero("");
//        System.out.println(hero1.getPhrase());
//        System.out.println(hero2.getPhrase());
//        System.out.println(hero3.getPhrase());

    }

    private static void workWithStatic() {
        Person[] people = {
                new Person("Bolek"),
                new Person(null),
                new Person("Lelek"),
                new Person(null),
                new Person("Tolek"),
                new Person("Maksim"),
                new Person(null),
                new Person("Maksim"),
                new Person("Maksim"),
        };
        Random random = new Random(300);
        for (Person p : people) {
            p.setHeightInMeter(random.nextDouble() * 2.5);
        }
        for (Person p : people) {
            System.out.println(p.getName()
                    + " " + p.getPrettyHeight());
        }
        Person.setHeightPoints(
                1.3,
                1.51);
        System.out.println("=========");
        for (Person p : people) {
            System.out.println(p.getName()
                    + " " + p.getPrettyHeight());
        }
    }

    private static void workWithSetName() {
        Person person = new Person("Bolek");
        System.out.println(person.getName());
        System.out.println(person.getName().length());
        person.setName(null);
        System.out.println(person.getName());
        System.out.println(person.getName().length());
    }

    private static void workWithCalc() {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(5));
        System.out.println(calc.sum(5));
        System.out.println(calc.getCurrent());
        System.out.println(new Calculator().getCurrent());
    }
}
