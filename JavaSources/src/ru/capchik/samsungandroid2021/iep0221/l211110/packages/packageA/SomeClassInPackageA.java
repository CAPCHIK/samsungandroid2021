package ru.capchik.samsungandroid2021.iep0221.l211110.packages.packageA;

public abstract class SomeClassInPackageA {
    public int publicInt;
    private int privateInt;
    protected int protectedInt;
    int defaultInt;

    public void logic() {
        // Some logic
        doConcreteLogic();
        // Some another logic
    }

    protected abstract void doConcreteLogic();

}
