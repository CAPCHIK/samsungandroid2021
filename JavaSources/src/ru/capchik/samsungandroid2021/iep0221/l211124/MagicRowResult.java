package ru.capchik.samsungandroid2021.iep0221.l211124;

public class MagicRowResult {
    private final String magicRow;
    private final String errorMessage;

    private MagicRowResult(String magicRow, String errorMessage) {
        this.magicRow = magicRow;
        this.errorMessage = errorMessage;
    }

    public static MagicRowResult correct(String row){
        return  new MagicRowResult(row, null);
    }

    public static MagicRowResult error(String errorMessage){
        return  new MagicRowResult(null, errorMessage);
    }

    public boolean isError(){
        return errorMessage != null;
    }
    public String getMagicRow() {
        return magicRow;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
