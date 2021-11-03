package ru.capchik.samsungandroid2021.iep0221.l211013;

public class Square extends Rectangle{
    public Square(int size) {
        super(size, size);
    }
    public void setSize(int size) {
        setWidth(size);
        setHeight(size);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}
