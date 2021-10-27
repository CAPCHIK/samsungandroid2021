package ru.capchik.samsungandroid2021.iep0221.l211027;

public abstract class Hero implements CanBeLive {
    private int hp;
    private DeathNotifier deathNotifier;

    public Hero(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public abstract String getPhrase();

    public void applyDamage(int damage) {
        if (damage < 0) {
            damage = 0;
        }
        var wasAlive = isAlive();
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

    @Override
    public boolean isAlive() {
        return hp > 0;
    }


    @Override
    public String toString() {
        return "Hero{" +
                "" + getPhrase() +
                " hp=" + hp +
                " " + (isAlive() ? "Жив" : "Мёртв") +
                '}';
    }
}
