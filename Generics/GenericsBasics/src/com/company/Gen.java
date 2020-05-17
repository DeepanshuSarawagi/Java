package com.company;

// A simple generic class of type parameter T. T will be replaced by real type when object of Gen class is created with
// real type.

public class Gen<T> {
    T ob;               // declare an object of type T

    public Gen(T ob) {  // Create a constructor passing the reference to an object of type T
        this.ob = ob;
    }

    T getOb() {
        return this.ob;  // return the value of object type T
    }

    void showType() {
        System.out.println("Type of T is " +
                this.ob.getClass().getName());
    }
}
