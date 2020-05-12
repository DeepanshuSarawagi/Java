package com.company;

public abstract class Incomplete implements Callback{
    // If any class doesnt implement the methods declared in interface declaration then it must be declared as abstract.
    // Any class which inherits from this class should either implement all the methods declared in interface or should
    // call itself an abstract class.

    int a, b;
    void show() {
        System.out.println(a + " " + b);
    }
}
