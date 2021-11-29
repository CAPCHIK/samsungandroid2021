package ru.capchik.samsungandroid2021.iep0621.l211115;

public class Olkov07 {
    public static void main(String[] args) {
        float[] x = {100f, 200f, 200f, 100f}, y = {100f, 100f, 200f, 200f};
        Polygon a = new Polygon(x, y);
        Polygon b = new Polygon(a);
        a.draw();


        b.rotate(45.0f);
        System.out.println("a");
        a.draw();
        System.out.println("b");
        b.draw();
    }
}
class Polygon {
    private float[] x, y;
    public Polygon(float[] x, float[] y){

    }

    public Polygon(Polygon p){
        this.x = new float[p.x.length];
        this.y = new float[p.y.length];
        for (int i = 0; i < x.length; i++) {
            this.x[i] = p.x[i];
        }
        for (int i = 0; i < y.length; i++) {
            this.y[i] = p.y[i];
        }
    }

    public void draw(){
        System.out.print("x: ");
        for (float xValue: x) {
            System.out.print(xValue + " ");
        }
        System.out.println();

        System.out.print("y: ");
        for (float yValue: y) {
            System.out.print(yValue + " ");
        }
        System.out.println();
    }
    public void rotate(float deg){
        for (int i = 0; i < x.length; i++) {
            x[i] += deg;
        }
        for (int i = 0; i < y.length; i++) {
            y[i] += deg;
        }
    }

}