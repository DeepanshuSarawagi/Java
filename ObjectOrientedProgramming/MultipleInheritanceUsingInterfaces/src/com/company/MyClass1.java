package com.company;

public class MyClass1 implements Beta, Alpha{
    public MyClass1() {
        System.out.println("Default MyClass1 Constructor");
    }

    @Override
    public void reset() {
        System.out.println("Reset called from MyClass1 interface. It will error out if we dont override method here");
    }
}
