package ru.capchik.samsungandroid2021.iep0321.l211111.generics;

public class Main {
    public static void main(String[] args) {

        String row = getArg("Row");
        Army arg = getArg(new Army());

        Archer robin = (Archer) findHero("Robin");

        Archer correctRobin = findHeroGeneric("Robin");
        System.out.println(robin);
        System.out.println(correctRobin);

        Swordsman artur = findHeroGeneric("Artur");
        System.out.println(artur);

        // Пример аналогичности в поведении
//        Archer robinSonDirect = (Archer) findHero("RobinSon");
        Archer robinSon = findHeroGeneric("RobinSon");
        System.out.println(robinSon);

    }

    private static <T extends Hero> T findHeroGeneric(String name) {
        Hero h;
        switch (name) {
            case "Robin":
                h = new Archer(100500);
                break;
            default:
                h = new Swordsman();
                break;
        }
        return (T)h;
    }

    private static Hero findHero(String name) {
        switch (name) {
            case "Robin":
                return new Archer(100500);
            default:
                return new Swordsman();
        }
    }

    private static <T> T getArg(T arg) {
        return arg;
    }

    private static void workWithHeroes() {
        Hero[] heroes = {
                new Swordsman(),
                new Archer(32),
                new Archer(58),
                new Swordsman(),
                new Archer(5),
        };
        Squad<Hero> all = new Squad<>(heroes);

        Hero hero = all.get(1);

        Archer[] archers = {
                new Archer(32),
                new Archer(58),
                new Archer(5),
        };
        Squad<Archer> squad = new Squad<>(archers);
        Archer archer = squad.get(0);
        System.out.println(squad.getTotalHp());
    }

    private static void workWithBucket() {
        int c = 90;

        Bucket<Integer, Integer, Integer> b1 = new Bucket<>(54, 35, c);


        System.out.println(b1);
        System.out.println(sumTwoFirst(b1));
        System.out.println(b1.getA() + b1.getC());

        Bucket<String, String, String> b2 = new Bucket<>("Row1", "Row   2", "row>>>3");
        System.out.println(b2);

        Bucket<Integer, Integer, Double> numbersBucket = new Bucket<>(345, 12, 43.4);

        System.out.println(sumTwoFirst(numbersBucket));

        Bucket<Integer, Integer, String> b3 = new Bucket<>(345, 12, "row>>>3");
        // String это не Number, не компилируется
//        System.out.println(sumTwoFirst(b3));

        // Нельзя использовать типы без параметров! Это только пример!
        sumTwoFirst(new Bucket("null", "null", "null"));
    }

    private static int sumTwoFirst(Bucket<Integer, Integer, ? extends Number> b) {
        return b.getA() + b.getB();
    }

    private static void workWithObjectLogic() {
        ExampleClass someVariable = new ExampleClass();
        System.out.println(someVariable);
        System.out.println(someVariable.getText());

        workWithObject(someVariable);

        workWithObject(new FakeClass());
        workWithObject(new SecondExample());
    }

    private static void workWithObject(Object object) {
        System.out.println("toString " + object);
        if (object instanceof ExampleClass) {
            ExampleClass exampleClass = (ExampleClass) object;
            System.out.println("getText " + exampleClass.getText());
        } else {
            System.out.println("Bad class");
        }
    }
}
