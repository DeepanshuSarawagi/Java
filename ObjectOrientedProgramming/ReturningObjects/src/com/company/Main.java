package com.company;

public class Main {

    public static void main(String[] args) {
        Test test = new Test(2);
        System.out.println("Value of a is " + test.getA());
        Test test2;
        test2 = test.incrmntByTen();
        System.out.println("Value of a is " + test2.getA());
        test2 = test2.incrmntByTen();
        System.out.println("Value of a is " + test2.getA());

        // As you can see, each time incrmntByTen() is called, a new object is created and a reference to that is
        // returned to the calling routine.
    }
}

class Test{
    int a;

    Test(int i) {
        this.a = i;
    }

    public int getA() {
        return a;
    }

    Test incrmntByTen() {

        Test test = new Test(a+10);
        return test;
    }
}
