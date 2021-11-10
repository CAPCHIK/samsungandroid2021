package ru.capchik.samsungandroid2021.iep0221.l211110.generics;

public class Bucket<T> {
    private final T a;
    private final T b;
    private final T c;

    public Bucket(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }

    public T getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
