package ru.capchik.samsungandroid2021.iep0621.l211025;

public class OrdaHero extends Hero {
    public OrdaHero(int hp) {
        super(hp);
    }

    @Override
    public String say() {
        return "Опять работа?!";
    }

    @Override
    public String toString() {
        return "OrdaHero " + super.toString();
    }
}
