package ru.capchik.samsungandroid2021.iep0621.l211025;

public class HeroDieHandler implements DieHandler {
    private Hero targetHero;

    public HeroDieHandler(Hero targetHero) {
        this.targetHero = targetHero;
    }


    @Override
    public void die() {
        System.out.println(targetHero.getHp() + " was die!!!");
    }
}
