package ru.capchik.samsungandroid2021.iep0621.l211115;

public class Olkov09 {
    public static void main(String[] args) {
        Vegetable v = new Potato();
        v.cultivate();
        Potato p = new Potato();
    }
}
abstract class Vegetable{
    public String name;
    public final void cultivate(){}
    public abstract void harvest();
}

class Potato extends Vegetable{
    public void harvest(){}
    public void debug(){}
}