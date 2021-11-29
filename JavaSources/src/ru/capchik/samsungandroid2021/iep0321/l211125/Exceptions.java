package ru.capchik.samsungandroid2021.iep0321.l211125;

import ru.capchik.samsungandroid2021.iep0221.l211124.IncorrectMagicRowException;
import ru.capchik.samsungandroid2021.iep0221.l211124.MyRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class Exceptions {
    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
        }
        try {
            throwRuntime();
        } catch (MyRuntimeException npe) {
            System.out.println("А вот и моё исключение");
            StackTraceElement[] stackTrace = npe.getStackTrace();
            for(StackTraceElement element : stackTrace) {
                System.out.println("Метод " + element.getMethodName() + " строка " + element.getLineNumber());
            }
        }

        try {
            buildMagicRowWithException(34, 56);
        } catch (IncorrectMagicRowParametersException e) {
            e.printStackTrace(System.out);
        }
        throwRuntime();
    }


    private static void throwRuntime() throws MyRuntimeException {
        throw new MyRuntimeException();
    }

    private static void doSome(String row) {
        System.out.println(row.length());
    }

    private static void workWithException() {
        try {
            String s = buildMagicRowWithException(14, 452.5);
            System.out.println(s);
        } catch (Param1IsMultipleOf7Exception e) {
            System.out.println("Параметр 1 должен быть не кратен 7");
        } catch (Param2NotLessThanParam1Exception e) {
            System.out.println("Параметр 2 должен быть меньше первого");
        } catch (IncorrectMagicRowParametersException e) {
            System.out.println("Не можем создать магическую строку, повторите позже");
        }
    }

    public static String buildMagicRowWithException(int param1, double param2) throws IncorrectMagicRowParametersException {
        if (param2 >= param1) {
            IncorrectMagicRowParametersException exception =
                    new Param2NotLessThanParam1Exception();
            throw exception;
        }

        if (param1 % 7 == 0) {
            throw new Param1IsMultipleOf7Exception();
        }

        return "Amazing magic RoW " + param1 + " And param2 is awesome " + param2 + " 🎉🎉🔥🔥";
    }

    private static void workWithResult() {
        MagicRowResult magicRow = buildMagicRowWithResult(49, 3.14);
        if (magicRow.isError()) {
            switch (magicRow.getErrorCode()) {
                case MagicRowResult.PARAM2_NOT_LESS_THAN_PARAM1:
                    System.out.println("Параметр 2 должен быть меньше первого");
                    break;
                case MagicRowResult.PARAM1_IS_MULTIPLE_OF_7:
                    System.out.println("Параметр 1 должен быть не кратен 7");
                    break;
                default:
                    System.out.println("Магическая строка не может быть собрана, простите");
                    break;
            }
        } else {
            System.out.println(magicRow.getMagicRow());
        }
    }

    public static MagicRowResult buildMagicRowWithResult(int param1, double param2) {
        if (param2 >= param1) {
            return MagicRowResult.param2NotLessThanParam1();
        }

        if (param1 % 7 == 0) {
            return MagicRowResult.error(MagicRowResult.PARAM1_IS_MULTIPLE_OF_7);
        }

        return MagicRowResult.correct("Amazing magic RoW " + param1 + " And param2 is awesome " + param2 + " 🎉🎉🔥🔥");
    }

    private static void workWithString() {
        String magicRow = buildMagicRow(65, 3.14);
        System.out.println(magicRow);

        String magicRow2 = buildMagicRow(65, 350.14);
        if (magicRow2 == null) {
            System.out.println("Магическая строка не может быть собрана");
        } else {
            System.out.println(magicRow2);
        }

        String magicRow3 = buildMagicRow(49, 3.14);
        if (magicRow3 == null) {
            System.out.println("Магическая строка не может быть собрана");
        } else {
            System.out.println(magicRow3);
        }
    }

    public static String buildMagicRow(int param1, double param2) {
        if (param2 >= param1) {
            return null;
        }

        if (param1 % 7 == 0) {
            return null;
        }

        return "Amazing magic RoW " + param1 + " And param2 is awesome " + param2 + " 🎉🎉🔥🔥";
    }
}
