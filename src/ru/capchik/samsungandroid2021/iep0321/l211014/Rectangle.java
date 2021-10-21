package ru.capchik.samsungandroid2021.iep0321.l211014;

public class Rectangle extends Shape{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(int size) {
        this(size, size);
    }
    public boolean isSquare() {
        return width == height;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return width + " X " + height;
    }
}
