package ru.capchik.samsungandroid2021.iep0221.l211013;

public class Calculator {
    private int current = 0;

    public int sum(int num) {
        current += num;
        return current;
    }

    public int getCurrent() {
        return current;
    }
}
