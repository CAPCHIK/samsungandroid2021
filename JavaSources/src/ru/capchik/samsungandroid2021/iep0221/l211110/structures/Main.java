package ru.capchik.samsungandroid2021.iep0221.l211110.structures;

import java.util.*;

class Car {
    private final int number;

    Car(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

public class Main {
    public static void main(String[] args) {
        // FIFO
        // First In First Out
        Queue<String> queue = new LinkedList<>();

        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");

        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue.peek());

        System.out.println(queue.remove());

        System.out.println(queue);

        System.out.println(queue.remove());

        System.out.println(queue);
        System.out.println(queue.remove());

        System.out.println(queue);
    }

    private static void workWithStack() {
        // FILO
        // First In Last Out
        Stack<String> exampleStack = new Stack<>();

        exampleStack.push("Item 1");
        exampleStack.push("Item 2");
        exampleStack.push("Item 3");

        System.out.println(exampleStack);

        System.out.println(exampleStack.peek());
        System.out.println(exampleStack.peek());

        System.out.println(exampleStack.pop());

        System.out.println(exampleStack);

        System.out.println(exampleStack.pop());

        System.out.println(exampleStack);
        System.out.println(exampleStack.pop());

        System.out.println(exampleStack);

        method1();
    }

    private static void method1() {
        methdo2();
    }

    private static void methdo2() {
        method3();
    }

    private static void method3() {
        System.out.println("method3");
    }

    private static void workWithSet() {
        Set<String> ints = new HashSet<>();

        System.out.println(ints.add("car1"));
        System.out.println(ints.add("car2"));

        System.out.println(ints.remove("car1"));

        System.out.println(ints.add("car1"));

        ints.add("sdfsdf3");
        ints.add("sdfsdf2");
        ints.add("sdfsdf1");

        for (String car : ints) {
            System.out.println(car);
        }


        System.out.println(ints);

        Set<Car> cars = new HashSet<>();
        cars.add(new Car(123));
        cars.add(new Car(123));
        cars.add(new Car(123));
        System.out.println(cars);

        System.out.println(cars.size());


        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car(123));
        carsList.add(new Car(123));
        carsList.add(new Car(123));
        System.out.println(carsList);

        System.out.println(carsList.size());
    }

    private static void workWithList() {
        List<Integer> ints = new ArrayList<>();

        ints.add(546);
        ints.add(860);
        ints.add(-456);
        ints.add(45);

        ints.add(1, 0);
        ints.set(2, -500);
        ints.remove((Integer) 45);


        System.out.println(ints);


        LinkedList<String> linkedList = new LinkedList<>();

        List<String> strings = linkedList;

        strings.add("New row!!!");
        strings.add(0, "some new row");
        strings.add(0, "some new row 2");
        strings.add(0, "some new row 3");
        strings.add(0, "some new row 3");

        strings.remove(0);

        String s = strings.get(2);

        System.out.println(strings);
        System.out.println(s);
    }

    private static void dynamicArray() {
        int[] array = {3, 3};
        print(array);
        array = appendItem(array, 8);
        print(array);
    }

    private static void print(int[] array) {
        for (int v : array) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    private static int[] appendItem(int[] array, int newValue) {
        int[] temp = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        temp[array.length] = newValue;
        return temp;
    }
}
