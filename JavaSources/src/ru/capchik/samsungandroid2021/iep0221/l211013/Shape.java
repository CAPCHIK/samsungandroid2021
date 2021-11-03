package ru.capchik.samsungandroid2021.iep0221.l211013;

public abstract class Shape {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getSquare();
}
