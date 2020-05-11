package com.company;

public class MethodOverriding {
    public static void main(String[] args) {
        B objB = new B(2, 3,4);
        objB.show();
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

    public void show() {
        System.out.println("c is: " + c);
    }
}