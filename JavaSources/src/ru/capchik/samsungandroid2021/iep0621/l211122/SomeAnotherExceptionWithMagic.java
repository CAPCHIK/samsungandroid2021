package ru.capchik.samsungandroid2021.iep0621.l211122;

public class SomeAnotherExceptionWithMagic  extends IncorrectMagicRowException{
    @Override
    public String getMessage() {
        return "SomeAnotherExceptionWithMagic";
    }
}
