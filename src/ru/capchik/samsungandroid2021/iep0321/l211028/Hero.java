package ru.capchik.samsungandroid2021.iep0321.l211028;

public abstract class Hero implements DamageTaker {
    private int hp;
    private DeathNotifier deathNotifier;

    public Hero(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void applyDamage(int damage) {
        if (damage < 0) {
            damage = 0;
        }
        boolean wasAlive = isAlive();
        hp -= damage;
        if (wasAlive && !isAlive()) {
            if (deathNotifier != null) {
                deathNotifier.newDeath(this);
            }
        }
    }

    public void setDeathNotifier(DeathNotifier deathNotifier) {
        this.deathNotifier = deathNotifier;
    }

    @Override
    public void takeDamage(int damage) {
        applyDamage(damage);
    }

    public abstract String getPhrase();

    @Override
    public String toString() {
        return "Hero{" +
                (isAlive() ? "Жив" : "Мёртв") + " " +
                getPhrase() +
                " hp=" + hp +
                '}';
    }

}
