package ru.capchik.samsungandroid2021.iep0221.l211013;

public class Main {
    public static void main(String[] args) {
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
