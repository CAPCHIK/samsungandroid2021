package ru.capchik.samsungandroid2021.iep0321.l211014;

public class Hero {
    private int hp;

    public Hero(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String say(){
        return "*звуки неловкого молчания*";
//        switch (type){
//            case "Орда": return "Опять работа?!";
//            case "Альянс": return "За Альянс!";
//            case "Нежить": return "Смерть за Нерзула!";
//            default:
//        }
    }
}
