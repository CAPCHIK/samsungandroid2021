package ru.capchik.samsungandroid2021.iep0221.l211124;

import java.util.ArrayList;
import java.util.List;

public class Exceptions {
    public static void main(String[] args) {
        try {
            doSome();
        } catch (NullPointerException npe) {
            StackTraceElement[] stackTrace = npe.getStackTrace();
            for(StackTraceElement stackTraceElement : stackTrace) {
                System.out.println(stackTraceElement.getMethodName() + " " + stackTraceElement.getLineNumber());
            }
            npe.printStackTrace(System.out);
        }
        try {
            int i = Integer.parseInt("123");
            System.out.println(4 / 0);
        } catch (NumberFormatException nme) {
            System.out.println("строка не является числом");
        }
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        doSome();
    }

    private static void doSome() throws MyRuntimeException {
        System.out.println("lol kek");
        String s = null;
        System.out.println(s . length());
    }

    private static void workWithMultipleExceptionTypes() {
        try {
            String magicRow = calculateMagicRowWithException(60.8, 46);
            System.out.println(magicRow);
            System.out.println(magicRow.length());
        } catch (SomeAnotherValueGreaterThanValueAtStartException e) {
            System.out.println("Второе значение должно быть меньше первого!");
        } catch (SomeAnotherValueMultipleOf3 e) {
            System.out.println("Второе значение не должно быть кратно трём!");
        } catch (IncorrectMagicRowException e) {
            System.out.println("Простите, невозможно создать строку, попробуйте позже :(");
        }
    }

    public static String calculateMagicRowWithException(double valueAtStart, int someAnotherValue) throws IncorrectMagicRowException {
        if (someAnotherValue >= valueAtStart) {
            IncorrectMagicRowException exception = new SomeAnotherValueGreaterThanValueAtStartException();
            throw exception;
        }
        if (someAnotherValue % 3 == 0) {
            throw new SomeAnotherValueMultipleOf3();
        }
        int g = someAnotherValue / 0;
        return "Hello! " + valueAtStart + " I am magic row!! " + someAnotherValue + " 🎉🎉❤";
    }

    private static void workWithResult() {
        String magicRow = calculateMagicRow(6.8, 4);
        System.out.println(magicRow);
        System.out.println(magicRow.length());

        MagicRowResult magicRow2 = calculateMagicRowWithResult(60.8, 42);
        if (magicRow2.isError()) {
            System.out.println("Magic row can't be created " + magicRow2.getErrorMessage());
        } else {
            System.out.println(magicRow2.getMagicRow());
        }
    }


    public static MagicRowResult calculateMagicRowWithResult(double valueAtStart, int someAnotherValue) {
        if (someAnotherValue >= valueAtStart) {
            return MagicRowResult.error("someAnotherValue must be lower than valueAtStart");
        }
        if (someAnotherValue % 3 == 0) {
            return MagicRowResult.error("someAnotherValue % 3 must be not equal 0");
        }
        return MagicRowResult.correct("Hello! " + valueAtStart + " I am magic row!! " + someAnotherValue + " 🎉🎉❤");
    }

    public static String calculateMagicRow(double valueAtStart, int someAnotherValue) {
        if (someAnotherValue >= valueAtStart) {
            return null;
        }
        if (someAnotherValue % 3 == 0) {
            return null;
        }
        return "Hello! " + valueAtStart + " I am magic row!! " + someAnotherValue + " 🎉🎉❤";
    }

}
