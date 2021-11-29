package ru.capchik.samsungandroid2021.iep0321.l211125;

public class MagicRowResult {

    public static final int PARAM2_NOT_LESS_THAN_PARAM1 = 1;
    public static final int PARAM1_IS_MULTIPLE_OF_7 = 2;

    private final String magicRow;
    private final int errorCode;

    private MagicRowResult(String magicRow, int errorCode) {
        this.magicRow = magicRow;
        this.errorCode = errorCode;
    }

    public static MagicRowResult correct(String magicRow) {
        return new MagicRowResult(magicRow, -1);
    }

    public static MagicRowResult error(int errorCode) {
        return new MagicRowResult(null, errorCode);
    }

    public static MagicRowResult param2NotLessThanParam1() {
        return new MagicRowResult(null, PARAM2_NOT_LESS_THAN_PARAM1);
    }

    public boolean isError() {
        return errorCode != -1;
    }

    public String getMagicRow() {
        return magicRow;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
