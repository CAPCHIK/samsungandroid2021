package ru.capchik.samsungandroid2021.iep0321.l211028;

public class Wall implements DamageTaker{
    @Override
    public void takeDamage(int damage) {
        // Писать в консоль в этом  месте не очень хорошо
        // Сдесь сделали так только в рамках лекции, для показательсности работы
        System.out.println("Непробиваемая стена впитывает " + damage);
    }
}
