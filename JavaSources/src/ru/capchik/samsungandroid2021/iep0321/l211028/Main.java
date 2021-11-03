package ru.capchik.samsungandroid2021.iep0321.l211028;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Hero[] army = {
                new Archer(),
                new Archer(),
                new Swordsman(70),
                new Swordsman(98)
        };

        DeathNotifier notifier =
                new ConsoleArmyDeathNotifier(army);


        army[3].setDeathNotifier(notifier);
        army[1].setDeathNotifier(notifier);

        DeathNotifier anonymousDeathNotifier = new DeathNotifier() {
            @Override
            public void newDeath(Hero hero) {
                System.out.println("Потери в армии! Теперь у нас бойцов: " + countAliveHeroes(army));
            }
        };

        army[0].setDeathNotifier(anonymousDeathNotifier);

        army[2].setDeathNotifier(h -> System.out.println("Последний герой был убит " + countAliveHeroes(army)));

        printArmy(army);
        Wall wall = new Wall();

        applySomeDamage(army);
        printArmy(army);

        applySomeDamage(army[0], wall, army[3]);
        printArmy(army);

        applySomeDamage(army[2]);
        printArmy(army);
    }

    private static void applySomeDamage(DamageTaker... units) {
        Random random = new Random(45882);
        for (DamageTaker unit : units) {
            int damage = Math.abs(random.nextInt() % 240);
            unit.takeDamage(damage);
        }
    }


    private static void printArmy(Hero[] army) {
        System.out.println("==== Живо: "+ countAliveHeroes(army) +" ======");
        for (Hero hero : army) {
            System.out.println(hero);
        }
        System.out.println("==========");
    }

    private static int countAliveHeroes(Hero[] army) {
        int count = 0;
        for (Hero hero : army) {
            if (hero.isAlive()) {
                count++;
            }
        }
        return count;
    }
}