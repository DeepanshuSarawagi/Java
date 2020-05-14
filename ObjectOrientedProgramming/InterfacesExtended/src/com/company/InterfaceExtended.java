package com.company;

public class InterfaceExtended implements MyInterface2{
    // As you can see, when we implemented the class InterfaceExtended with MyInterface2 all the three methods have to
    // be implemented here by default or else there would be compile error.
    @Override
    public void meth3() {
        System.out.println("Method 3 is called");
    }

    @Override
    public void meth1() {
        System.out.println("Method 1 is called");
    }

    @Override
    public void meth2() {
        System.out.println("Method 2 is called");
    }
}
