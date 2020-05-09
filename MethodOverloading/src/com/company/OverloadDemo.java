package com.company;

public class OverloadDemo {
    void test() {
        System.out.println("No parameters");
    }

    void test(int a ) {
        System.out.println("a is " + a);
    }

    void test(int a, int b) {
        System.out.println("a and b: " + a + " " + b);
    }

    double test (double a) {
        return a*a;
    }
}

class Overload {
    public static void main(String[] args) {
        OverloadDemo od = new OverloadDemo();

        od.test();
        od.test(2);
        od.test(2, 3);
        double result = od.test(12.4);
        System.out.println("Result of od.test(12.4) is " + result);
    }
}
