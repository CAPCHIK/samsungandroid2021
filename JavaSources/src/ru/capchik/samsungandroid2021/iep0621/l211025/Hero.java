package ru.capchik.samsungandroid2021.iep0621.l211025;

public abstract class Hero implements DamageTaker {
    private static int baseDamage = 50;
    private int hp;
    private DieHandler dieHandler;

    public Hero(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public abstract String say();

    public static void setBaseDamage(int baseDamage) {
        Hero.baseDamage = Math.max(baseDamage, 1);
    }

    @Override
    public void takeBaseDamage() {
       takeDamage(baseDamage);
    }

    @Override
    public void takeDamage(int damage) {
        boolean wasAlive = !isDead();
        hp -= damage;
        if (wasAlive && isDead()) {
            if (dieHandler != null) {
                dieHandler.die();
            }
        }
    }

    public void setDieHandler(DieHandler dieHandler) {
        this.dieHandler = dieHandler;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "hp=" + hp +
                ", isDead=" + (isDead() ? "yes" : "no")  +
                '}';
    }
}
