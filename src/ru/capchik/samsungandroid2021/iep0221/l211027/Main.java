package ru.capchik.samsungandroid2021.iep0221.l211027;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Hero[] army = {
                new Swordsman(123),
                new Archer(),
                new Archer(),
                new Swordsman(50)
        };

        DeathNotifier consoleDeathNotifier = new ConsoleDeathNotifier(army);

        army[0].setDeathNotifier(consoleDeathNotifier);
        army[3].setDeathNotifier(consoleDeathNotifier);

        DeathNotifier anonymousDeathNotifier = new DeathNotifier() {
            @Override
            public void newDeath(Hero hero) {
                System.out.println("Из анонима ясно, осталось " + calcAliveHeroesCount(army));
            }
        };
        army[2].setDeathNotifier(anonymousDeathNotifier);

        army[1].setDeathNotifier((h) -> {
                    System.out.println("Привет из лямбды, умер " + h);
                }
        );

        Tower tower = new Tower();

        printInfoAboutArmy(army);

        applySomeDamage(army);
        applySomeDamage(army[0], army[3], tower);

        printInfoAboutArmy(army);

        applySomeDamage(army[1]);

        printInfoAboutArmy(army);
    }

    private static void printInfoAboutArmy(Hero[] army) {
        System.out.println("==========");
        System.out.println("Армия насчитывает бойцов: " + calcAliveHeroesCount(army));
        for (Hero h : army) {
            System.out.println(h);
        }
        System.out.println("==========");
    }

    private static int calcAliveHeroesCount(Hero[] army) {
        int count = 0;
        for (Hero h : army) {
            if (h.isAlive()) {
                count++;
            }
        }
        return count;
    }

    private static void applySomeDamage(DamageTaker... army) {
        Random random = new Random(451);
        for (DamageTaker damageTaker : army) {
            int damage = Math.abs(random.nextInt() % 200);
            damageTaker.takeDamage(damage);
        }
    }
}
