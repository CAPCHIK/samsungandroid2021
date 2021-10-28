package ru.capchik.samsungandroid2021.iep0321.l211028;

public class ConsoleArmyDeathNotifier implements DeathNotifier {
    private final Hero[] army;

    public ConsoleArmyDeathNotifier(Hero[] army) {
        this.army = army;
    }

    @Override
    public void newDeath(Hero hero) {
        System.out.println(
                "Умер герой "+
                hero +
                ". Теперь численность армии: " +
                calcAliveCount(army));
    }

    private int calcAliveCount(Hero[] army) {
        int count = 0;
        for (Hero hero : army) {
            if (hero.isAlive()) {
                count++;
            }
        }
        return count;
    }
}
