package ru.capchik.samsungandroid2021.iep0621.l211025;

public class Main {
    public static void main(String[] args) {
        Hero[] army = {
            new AlyansHero(500),
            new AlyansHero(800),
            new OrdaHero(2)
        };
        // Создали экземпляр класса
        HeroDieHandler heroDieHandler = new HeroDieHandler(army[0]);
        // Можем "смотреть" на него через призму выше стоящих сущностей
        DieHandler dieHandler = heroDieHandler;
        Object object = heroDieHandler;
        object.toString();
        Hero hero = army[0];

        army[0].setDieHandler(new DieHandler() {
            @Override
            public void die() {
                System.out.println("First hero was die");
            }
        });

        army[2].setDieHandler(() -> System.out.println("Orda was die"));


        Wall w = new Wall();
        DamageTaker[] dt = {army[0], army[1], army[2], w};
        applyDamage(dt, 20);
        for (Hero h : army) {
            System.out.println(h);
        }
        applyDamage(army, 600);
        for (Hero h : army) {
            System.out.println(h);
        }
    }

    public static void applyDamage(DamageTaker[] takers, int damage) {
        for (DamageTaker t : takers) {
            t.takeDamage(damage);
            t.takeBaseDamage();
        }
    }
}
