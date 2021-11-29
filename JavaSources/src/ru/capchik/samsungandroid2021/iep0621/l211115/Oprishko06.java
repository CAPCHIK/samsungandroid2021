package ru.capchik.samsungandroid2021.iep0621.l211115;

import java.io.PrintStream;

public class Oprishko06 {
    private int value;

    public Oprishko06() {
        this(1);
    }

    public Oprishko06(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        new Oprishko06();
        new Oprishko06(23);

        PrintStream out = System.out;
        out.println("Hello!");
    }
}
