package ru.capchik.samsungandroid2021.iep0621.l211108.generics;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Squad<Archer> squad = new Squad<Archer>();
        squad.addHero(new Archer());
        squad.addHero(new Archer());

        Hero hero = squad.getHero(0);
        System.out.println(squad.getSquadHp());
    }

    private static void workWithHardGeneric() {
        System.out.println((int)56.9);
        Vector2<Integer> v1 = new Vector2<Integer>(1, 9);
        Vector2<Integer> sum = v1.sum(new Vector2<Integer>(5, 5));
        System.out.println(sum);
        System.out.println(v1.getX());
        Integer i = 6;

        Vector2<Float> floatVector2 = new Vector2<Float>(43f, 546f);
    }

    private static void workWIthGenericFirst() {
        Random r = new Random(5436);
        Bucket<Integer> bucket = new Bucket<Integer>(
                r.nextInt() % 100,
                r.nextInt() % 100,
                r.nextInt() % 100);
        System.out.println(bucket);
        System.out.println("Sum from generic: " + (bucket.getA() + bucket.getB()));
        sumTwoFirst(bucket);

        Bucket<String> bucket2 = new Bucket<String>("row1", "row2", "row3");
        System.out.println(bucket2);
        System.out.println("Length of string is:" + bucket2.getB().length());

//        Bucket<Double> bucket3 = new Bucket<Double>("Object1", -65.9, new Example());
//        System.out.println(bucket3);
//        Object a = bucket3.getA();


        ArrayList<String> list = new ArrayList<>();
        list.add("54");
        list.add("3 wwe sf ");
        list.add("4f 3 234");
        System.out.println(list);
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());

        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(45);
        ints.add(54);
        System.out.println(ints.get(0) + ints.get(1));

        // int - Integer
        // double - Double
        // ...

        Integer integer = 54;
        int primitive = 54;
    }


    private static void sumTwoFirst(Bucket<Integer> bucket) {
        int b = bucket.getB();
        int sum = bucket.getA() + bucket.getB();
        System.out.println(sum);
    }


    private static void workWithObjectLogic() {
        Example bucket = new Example();
        workWithObject(bucket);
        workWithObject(new Main());
        workWithObject(new SecondExample());
    }

    private static void workWithObject(Object object) {
        System.out.println(object.toString());
        if (object instanceof Example) {
            Example e = (Example) object;
            System.out.println(e.getString());
        } else {
            System.out.println("object is not bucket");
        }
    }
}
