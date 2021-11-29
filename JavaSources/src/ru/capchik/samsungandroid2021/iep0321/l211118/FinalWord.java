package ru.capchik.samsungandroid2021.iep0321.l211118;

public class FinalWord {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int localIndex = i;

        }
    }
}

abstract class A {
    private final int field = 3;
    public final void method() {}
    public abstract void absMeth();
}

//final class B extends ru.capchik.samsungandroid2021.iep0321.l211118.Golovnin.A {

//    Не скомпилируется
//    public void method() {
//        super.method();
//    }


//    public void method2() {
//        super.method();
//    }
//
//    @Override
//    public void absMeth() {
//
//    }
//}

// Не скомпилируется
//class C extends B {
//
//}
