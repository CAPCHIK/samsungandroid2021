package ru.capchik.samsungandroid2021.generics;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SomeGenericType type = new SomeGenericType("O",'f');
        SomeGenericType<Object> type2 = new SomeGenericType<>("O",'f');
        Object value1 = type.getValue1();

        System.out.println(DoAction(type));
        System.out.println(DoAction(type2));

        Main m = getSome();


    }

    private static <T extends Object> T getSome(){return null;}

    private static int DoAction(SomeGenericType<Integer> someType) {
        return someType.getValue1() + someType.getValue2();
    }
}

class SomeGenericType<T> {
    private T value1;
    private T value2;

    public SomeGenericType(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getValue1() {
        return value1;
    }

    public T getValue2() {
        return value2;
    }

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    public void setValue2(T value2) {
        this.value2 = value2;
    }
}
