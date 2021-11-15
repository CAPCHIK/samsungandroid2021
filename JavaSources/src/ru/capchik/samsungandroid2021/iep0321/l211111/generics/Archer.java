package ru.capchik.samsungandroid2021.iep0321.l211111.generics;

public class Archer extends Hero {
    private int hp;

    public Archer(int hp) {
        this.hp = hp;
    }

    @Override
    int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "Archer{" +
                "hp=" + hp +
                '}';
    }
}
