package ru.capchik.samsungandroid2021.iep0321.l211111.datastructures;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> cars = new HashSet<>();

        System.out.println(cars.add("another-car-2"));
        System.out.println(cars.add("car-number-1"));

        System.out.println(cars.remove("car-number-1"));

        System.out.println(cars.add("car-number-1")); 

        System.out.println(cars.remove("whoami"));

        System.out.println(cars);

    }

    private static void workWithList() {
        List<Integer> list = new ArrayList<>();

        list.add(5465);
        list.add(-456);
        list.add(42345);
        System.out.println(list);

        list.set(0, -9);
        System.out.println(list);

        list.add(2, 43);
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        int index = list.indexOf(43);
        System.out.println("index: " + index);
        list.remove(index);
        System.out.println(list);

        list.remove((Integer) 42345);
        System.out.println(list);

        List<String> rows = new ArrayList<>();
        rows.add("ROW1");
        rows.add("ROW2");
        rows.add("ROW3");
        rows.add("ROW1");

        System.out.println(rows);
        rows.remove("ROW1");
        System.out.println(rows);
    }

    private static void workWithArrays() {
        int[] someNumbers = {1, 3, 4};
        printArray(someNumbers);
        someNumbers = addNumberToArray(someNumbers, 7);
        printArray(someNumbers);
    }

    private static void printArray(int[] array){
        for (int value: array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static int[] addNumberToArray(int[] someNumbers, int i) {
        int[] newArray = new int[someNumbers.length + 1];
        for (int j = 0; j < someNumbers.length; j++) {
            newArray[j] = someNumbers[j];
        }
        newArray[someNumbers.length] = i;
        return newArray;
    }
}
