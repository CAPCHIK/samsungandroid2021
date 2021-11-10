package ru.capchik.samsungandroid2021.iep0221.l211110.generics;

public class Main {
    public static void main(String[] args) {

        System.out.println(sumHp(new Swordsman(45), new Archer(54)));

        Swordsman alex = getHero("NO Alex");
        System.out.println(alex);

    }

    private static <H extends Hero> H getHero(String name) {
        switch (name) {
            case "Alex": return (H)new Swordsman(123);
            default: return (H)new Archer(32);
        }
    }

    private static <H extends Hero> int sumHp(H hero1, H hero2) {
        return hero1.getHp() + hero2.getHp();
    }

    private static void workWithHeroes() {
        Archer[] heroes = {
                new Archer(20),
                new Archer(50),
                new Archer(20)
        };
        Squad<Archer> archers = new Squad<Archer>(heroes);
        System.out.println(archers.getHp());
        Archer hero = archers.getHero(1);
    }

    private static void workWithBucket() {
        Bucket<Integer> b1 = new Bucket<>(123, 543, 43);

        Bucket<Double> doubleBucket = new Bucket<>(43.5, 43.6, 67.3);

        int valueFromMethod = sumFirstInts(b1);

        System.out.println(valueFromMethod);

        Bucket<String> b2 = new Bucket<>("row1", "row2", "row3");
        Object b = b2.getB();
//        System.out.println(sumFirstInts(b2));

        int variable = 12;
        doSome(variable);

        Bucket<Integer> b3 = new Bucket<>(45, 0 , 5);
        System.out.println(sumFirstInts(b3));
    }

    private  static void doSome(Object o) {
        System.out.println(o);
    }

    private static int sumFirstInts(Bucket<Integer> bucket) {
        return bucket.getA() + bucket.getB();
//        return bucket.getA() + bucket.getB();
    }

    private static void workWithObjectLogic() {
        Example example = new Example();
        System.out.println(example);
        workWithObject(example);
        workWithObject(new Main());
        workWithObject(new SecondExample());
    }

    private static void workWithObject(Object object) {
//        System.out.println(object.getString());
        if (object instanceof Example) {
            Example ex = (Example) object;
            System.out.println(ex.getString());
        } else {
            System.out.println("Bad class");
        }
    }

    @Override
    public String toString() {
        return "Example{}";
    }
}
