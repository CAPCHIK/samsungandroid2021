package ru.capchik.samsungandroid2021.iep0621.l211122;

import java.util.ArrayList;

public class Exceptions {
    public static void main(String[] args) {
        try {
            System.out.println("code in try block");
//            System.out.println(args[90]);
            new ArrayList<String>().get(90);
        } catch (ArrayIndexOutOfBoundsException arrEx){
            System.out.println("Incorrect work with array");
        } finally {
            System.out.println("Come back soon");
        }
        throwsRuntime();
    }

    private static void throwsRuntime() {
        throw new MyRuntimeEx();
    }


    private static void workWithCustomException() {
        try {
            String s = calcSomeMagicRowWithCustomEx(56, 54);
            System.out.println(s);
        } catch (Value2IsMoreThanValueException e) {
            System.out.println("Значение 2 больше чем значение 1");
        } catch (Value2DiffValue1IsOne e) {
            System.out.println("Разница между значениями не должна составлять единицу");
        } catch (IncorrectMagicRowException e) {
//            e.printStackTrace();
            System.out.println("Простите, мы не были к этому готовы, отправтье разработчику эту информацию: "
                    +
                    e.getMessage());
        }
    }

    private static String calcSomeMagicRowWithCustomEx(int value1, double value2) throws IncorrectMagicRowException {
        if (value2 > value1) {
            throw new Value2IsMoreThanValueException();
        }
        if (value1 - value2 == 1) {
            throw new Value2DiffValue1IsOne();
        }
        if (value1 % 2 == 0) {
            throw new SomeAnotherExceptionWithMagic();
        }
        return "Correct magic row: " + value1 + " ~~~ " + value2 + "  🎉🎉";
    }

    private static void workWithBaseException() {
        try {
            String s = calcSomeMagicRowWithEx(56, 55);
            System.out.println(s);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("magic row can't be created " + e.getMessage());
        }
    }


    private static String calcSomeMagicRowWithEx(int value1, double value2) throws Exception {
        if (value2 >= value1) {
            throw new Exception("Value2 must be lower than value1");
        }
        if (value1 - value2 == 1) {
            throw new Exception("value1 - value2 can't be equals '1'");
        }
        return "Correct magic row: " + value1 + " ~~~ " + value2 + "  🎉🎉";
    }

    private static void workWithMagicRowResult() {
        String x1 = calcSomeMagicRow(67, 5.9).getRow();
        System.out.println(x1);
        System.out.println(x1.length());

        MagicRowResult x = calcSomeMagicRow(4, 5.9);
        if (!x.rowIsCorrect()) {
            System.out.println("x magic row can't be created " + x.getErrorMessage());
        } else {
            System.out.println(x.getRow());
            System.out.println(x.getRow().length());
        }

        MagicRowResult x2 = calcSomeMagicRow(7, 6.0);
        if (!x2.rowIsCorrect()) {
            System.out.println("x2 magic row can't be created " + x2.getErrorMessage());
        } else {
            System.out.println(x2);
            System.out.println(x2.getRow().length());
        }
    }

    private static void method(String some) {
        System.out.println("method invoke " + some);
    }

    private static MagicRowResult calcSomeMagicRow(int value1, double value2) {
        if (value2 >= value1) {
            return MagicRowResult.incorrectRow("Value2 must be lower than value1");
        }
        if (value1 - value2 == 1) {
            return MagicRowResult.incorrectRow("value1 - value2 can't be equals '1'");
        }
        return MagicRowResult.correctRow("Correct magic row: " + value1 + " ~~~ " + value2 + "  🎉🎉");
    }
}
