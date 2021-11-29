package ru.capchik.samsungandroid2021.iep0621.l211122;

public class MagicRowResult {
    private final String row;
    private final String errorMessage;
    private final boolean rowIsCorrect;

    private MagicRowResult(String row, String errorMessage, boolean rowIsCorrect) {
        this.row = row;
        this.errorMessage = errorMessage;
        this.rowIsCorrect = rowIsCorrect;
    }

    public static MagicRowResult correctRow(String correctRow) {
        return new MagicRowResult(correctRow, null, true);
    }
    public static MagicRowResult incorrectRow(String errorMessage) {
        return new MagicRowResult(null, errorMessage, false);
    }

    public boolean rowIsCorrect(){
        return rowIsCorrect;
    }

    public String getRow() {
        return row;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "MagicRowResult{" +
                "row='" + row + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", rowIsCorrect=" + rowIsCorrect +
                '}';
    }
}
