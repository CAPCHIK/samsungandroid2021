package ru.capchik.samsungandroid2021.iep0621.l211108.generics;

public class Vector2<T extends Number> {
    private T x;
    private T y;

    public Vector2(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public Vector2<T> sum(Vector2<T> another) {
        double sumXDouble = this.x.doubleValue() + another.x.doubleValue();
        double sumYDouble = this.y.doubleValue() + another.y.doubleValue();
        T sumX = (T) (Double) sumXDouble;
        T sumY = (T) (Double) sumYDouble;
        return new Vector2<T>(sumX, sumY);
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
