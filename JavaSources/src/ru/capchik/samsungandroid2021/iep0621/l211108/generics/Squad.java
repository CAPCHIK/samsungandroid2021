package ru.capchik.samsungandroid2021.iep0621.l211108.generics;

import java.util.ArrayList;

public class Squad<H extends Hero> {
    private ArrayList<H> heroes = new ArrayList<>();

    public void addHero(H hero) {
        heroes.add(hero);
    }

    public H getHero(int number) {
        return heroes.get(number);
    }

    public int getSquadHp() {
        int totalHp = 0;
        for (Hero h : heroes) {
            totalHp += h.getHp();
        }
        return totalHp;
    }
}
