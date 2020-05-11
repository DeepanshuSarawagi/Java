package com.company;

public class MethodOverriding {
    public static void main(String[] args) {
        B objB = new B(2, 3,4);
        objB.show();
        // You can Override methods when you implement inheritance in Java. When objB invokes the show() method, the
        // show() is class B is called. We use the super.show() to call the show() in super class 'A'.
    }
}
class A {
    private int a;
    private int b;

    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void show() {
        System.out.println("a and b are: " + a + " " + b);
    }
}

class B extends A{
    private int c;

    public B(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public void show() {
        super.show();  //this calls the show() method from the super class
        System.out.println("c is: " + c);
    }
}