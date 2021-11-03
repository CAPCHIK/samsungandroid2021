package ru.capchik.samsungandroid2021.iep0621.l211025;

public class Wall implements DamageTaker {
    @Override
    public void takeDamage(int damage) {
        System.out.println("wall takes damage " + damage);
    }

    @Override
    public void takeBaseDamage() {
        System.out.println("wall takes base");
    }
}
