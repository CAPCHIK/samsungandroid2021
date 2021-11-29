package ru.capchik.samsungandroid2021.iep0321.l211118.Golovnin;

public class Golovnin10 {
    public static void main(String[] args) {
        System.out.println(someFunc(new A()));
        System.out.println(someFunc(new B()));
        System.out.println(someFunc(new C()));
    }
    private static int someFunc(A a) {
        if (a instanceof B) {
            B b = (B)a;
            return b.f(5.0);
        }
        return a.f(5);
    }
}
class A {
    int f(int a) {
        return a+a;
    }
}

class B extends A {
    int f(int a) {
        return a*a;
    }
    int f(double a){
        return (int)a;
    }
}
class C extends B {
    int f(double a){
        return (int)(a - 1);
    }
}


class X  {
    int fun() { return 1; }
}

class Y extends X {

}