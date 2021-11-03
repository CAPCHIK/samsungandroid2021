package ru.capchik.samsungandroid2021.iep0321.l211014;

public class Calculator {
    private int current;

    public int sum(int number) {
        current += number;
        return current;
    }

    public int getCurrent() {
        return current;
    }
}
