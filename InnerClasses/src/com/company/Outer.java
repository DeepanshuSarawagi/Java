package com.company;

public class Outer {
    private int outer_x = 100;

    /*
    Few points to remember about inner class in Java.
    1) A nested class has access to the members of the class in which it is nested, including the private members.
    2) However, enclosing/outer class does not have access to the members of the inner class
    3) That's why we have used getter inside inner class so that outer class get the value of inner class member/variable
    4) An inner class is a non-static nested class
     */

    void test() {
        Inner inner = new Inner();
        inner.display();
        System.out.println("inner_x is " + inner.inner_x);
    }

    // This is an inner class
    class Inner{
        private int inner_x = outer_x / 2;
        private void display() {
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

        Outer2 outer2 = new Outer2();
        outer2.test();
    }
}

class Outer2{
    private int outer_x = 100;

    void test() {
        for (int i=0; i<10; i++) {
            class Inner {
                void display() {
                    System.out.println("display: outer_x " + outer_x);
                }
            }
            Inner inner = new Inner();  // Creating inner class oject within for loop block of code
            inner.display();
        }
    }
}