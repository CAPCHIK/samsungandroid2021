package ru.capchik.samsungandroid2021.iep0321.l211014;

public class AlyansHero extends Hero {
    public AlyansHero(int hp) {
        super(hp);
    }

    @Override
    public String say() {
        return "За Альянс!";
    }

    @Override
    public void setHp(int hp) {
        System.out.println("start set hp");
        super.setHp(hp);
    }
}
