package ru.capchik.samsungandroid2021.iep0321.l211111.generics;

public class Bucket<T1, T2, T3> {
    private final T1 a;
    private final T2 b;
    private final T3 c;

    public Bucket(T1 a, T2 b, T3 c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T1 getA() {
        return a;
    }

    public T2 getB() {
        return b;
    }

    public T3 getC() {
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
