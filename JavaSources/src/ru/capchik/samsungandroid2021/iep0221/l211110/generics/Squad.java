package ru.capchik.samsungandroid2021.iep0221.l211110.generics;

public class Squad<T extends Hero> {
    private final T[] heroes;

    public Squad(T[] heroes) {
        this.heroes = heroes;
    }

    public int getCount() {
        return heroes.length;
    }

    public T getHero(int position) {
        return heroes[position];
    }

    public int getHp(){
        int hp = 0;
        for (T h : heroes) {
            hp += h.getHp();
        }
        return hp;
    }
}
