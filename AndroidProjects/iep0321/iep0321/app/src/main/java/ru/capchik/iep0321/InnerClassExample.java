package ru.capchik.iep0321;

public class InnerClassExample {
    private int state;

    public InnerClassExample(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    public class SomeClass {
        public SomeClass(String lolkek) {

        }
        public String getState() {
            return  "Yay! " + state;
        }
    }

}
class AnotherClass {
    public static void main(String[] args) {
        InnerClassExample ex = new InnerClassExample(123);
        InnerClassExample.SomeClass sc = ex.new SomeClass("asd");

        ex.setState(1231241234);

        System.out.println(sc.getState());
    }
}