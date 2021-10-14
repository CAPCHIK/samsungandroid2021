package ru.capchik.samsungandroid2021.iep0321.l211014;

public class Hero {
    private final String type;


    public static Hero createAlyans() {
        return new Hero("Альянс");
    }

    public static Hero createOrda() {
        return new Hero("Орда");
    }

    public static Hero createNezit() {
        return new Hero("Нежить");
    }

    private Hero(String type) {
        this.type = type;
    }

    public String say(){
        switch (type){
            case "Орда": return "Опять работа?!";
            case "Альянс": return "За Альянс!";
            case "Нежить": return "Смерть за Нерзула!";
            default: return "*звуки неловкого молчания*";
        }
    }
}
