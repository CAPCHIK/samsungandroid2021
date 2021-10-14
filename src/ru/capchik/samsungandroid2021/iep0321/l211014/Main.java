package ru.capchik.samsungandroid2021.iep0321.l211014;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void printPerson(Person p) {
        System.out.println(
                p.getName()
                        + " " +
                        p.getSmartCategory()
                        + " #" +
                        p.getId()
        );
    }

    public static void main(String[] args) {
        Hero h1 = Hero.createAlyans();
        System.out.println(h1.say());
        Hero h2 = Hero.createOrda();
        System.out.println(h2.say());
        Hero h3 = Hero.createNezit();
        System.out.println(h3.say());

    }

    private static void workWithScans() {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        System.out.println(num1);
        int num2 = scanner.nextInt();
        System.out.println(num2);

//        int num1 = new Scanner(System.in).nextInt();
//        System.out.println(num1);
//        int num2 = new Scanner(System.in).nextInt();
//        System.out.println(num2);
    }

    private static void workWithStatic() {
        Random random = new Random(4577);

        Person[] people = {
                new Person("Lolek"),
                new Person("Bolek"),
                new Person("Tolek"),
                new Person(null),
                new Person(null)
        };
        for (Person p : people) {
            p.addIq((short) (random.nextInt() % 300));
        }
        for (Person p : people) {
            printPerson(p);
        }
        Person.setSmartBorders(40, 90);
        for (Person p : people) {
            printPerson(p);
        }
    }

    private static void workWithPerson() {
        Person person = new Person("Alex");
        printPerson(person);
        person.setName("L");
        printPerson(person);


        person.addIq((short) 43);
        person.addIq((short) -700);
        System.out.println(person.getIq());
        person.substractIq((short) 500);
        System.out.println(person.getIq());
    }

    private static void workWithCalculator() {
        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(45));
        System.out.println(calculator.sum(5));
        //...
        System.out.println(calculator.getCurrent());
        System.out.println(new Calculator().getCurrent());
    }

    private static void workWithBreakAndContinue() {
        int a = new Scanner(System.in).nextInt();
        int toFind = 15;
        for (int i = 0; i < a; i++) {
            if (i < 10) {
                continue;
            }
            System.out.println(i);
            if (i == 15) {
                System.out.println("FOUND!");
                break;
            }
        }
    }

    private static void workWithSwitch() {
        int a = new Scanner(System.in).nextInt();
        switch (a) {
            case 5:
                System.out.println("case 5");
                break;
            case 6:
                System.out.println("case 6");
                break;
            case 7:
            case 8:
                System.out.println("case 7 or 8");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
