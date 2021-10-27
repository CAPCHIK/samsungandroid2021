package ru.capchik.samsungandroid2021.iep0221.l211027;

public class Tower implements DamageTaker {

    @Override
    public void takeDamage(int damage) {
        // Так делать не очень хорошо, сделано только для демонстрации
        System.out.println("Стена впитывает " + damage + " урона");
    }

}
