package com.company;

public class Outer {
    private int outer_x = 100;

    void test() {
        Inner inner = new Inner();
        inner.display();
        System.out.println("inner_x is " + inner.getInner_x());
    }

    // This is an inner class
    class Inner{
        int inner_x = outer_x / 2;
        void display() {
            System.out.println("outer_x is " + outer_x);
        }

        private int getInner_x() {
            return inner_x;
        }
    }
}

class InnerClassDemo{
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
    }
}
