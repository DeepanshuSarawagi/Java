package com.company;

public class NonGen {
    /**
     * To understand the difference between generics and non-generics, lets consider the following example.
     */
    Object ob;  // Ob is now of type Object

    public NonGen(Object ob) {
        this.ob = ob;
    }

    public Object getOb() {
        return ob;
    }

    public void showType() {
        System.out.println("Type of Object " + getOb() + " is " + this.ob.getClass().getName());
    }
}
