package ru.capchik.samsungandroid2021.iep0321.l211111.generics;

public class Squad<T extends Hero> {
    private T[] heroes;

    public Squad(T[] heroes) {
        this.heroes = heroes;
    }
    public T get(int position){
        return heroes[position];
    }

    public int getTotalHp(){
        int totalHp = 0;
        for (Hero h : heroes) {
            totalHp += h.getHp();
        }
        return totalHp;
    }
}
