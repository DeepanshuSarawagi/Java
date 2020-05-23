package com.company;

public class GenConstructor {
    /**
     * It is possible for constructors to be generic even if their class is not. Consider the following example.
     * Because GenConstructor() specifies a parameter of generic type, it can be called with any type including Interger,
     * Float, Double.
     */
    private double val;
    <T extends Number> GenConstructor(T arg) {
        this.val = arg.doubleValue();
    }

    void showVal() {
        System.out.println("val: " + val );
    }
}
