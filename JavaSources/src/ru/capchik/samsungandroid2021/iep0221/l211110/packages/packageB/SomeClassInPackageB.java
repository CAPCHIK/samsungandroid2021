package ru.capchik.samsungandroid2021.iep0221.l211110.packages.packageB;

import ru.capchik.samsungandroid2021.iep0221.l211110.packages.packageA.SomeClassInPackageA;

public class SomeClassInPackageB extends SomeClassInPackageA {
    public static void main(String[] args) {
//        SomeClassInPackageA p1 = null;
//        int publicInt = p1.privateInt;
//        int protectedInt = p1.protectedInt;
//        int defaultInt = p1.defaultInt;

    }
    void someLocalMethod() {
        int localProtectedInt = this.protectedInt;
        int localProtectedInt2 = super.protectedInt;
    }

    @Override
    protected void doConcreteLogic() {

    }
}
