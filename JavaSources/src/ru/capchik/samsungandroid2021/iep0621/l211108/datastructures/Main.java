package ru.capchik.samsungandroid2021.iep0621.l211108.datastructures;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Value 1");
        set.add("Value 2");
        set.add("Value 3");

        set.add("Value 1");


        System.out.println(set);

    }

    private static void workWithList() {
        ArrayList<String> arrayListRows = new ArrayList<>();
        LinkedList<String> linkedListRows = new LinkedList<>();

        handleList(arrayListRows);
        handleList(linkedListRows);


        System.out.println("arrayList: " + arrayListRows);
        System.out.println("linkedList: " + linkedListRows);


        clean(arrayListRows);
        System.out.println(arrayListRows);
    }

    private static void clean(List<String> rows) {
        rows.removeIf(item -> item.endsWith("d"));
    }

    private static void handleList(List<String> rows) {
        rows.add("Row 1 d");
        rows.add("Row 2 f");
        rows.add("3 row! d");
        rows.add("4 row! h");
        rows.add(" == 5 row! l");

        rows.remove("3 row!");
        rows.remove(1);


    }
}
