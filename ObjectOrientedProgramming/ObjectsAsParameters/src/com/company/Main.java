package com.company;

public class Main {

    public static void main(String[] args) {
	    // We can also pass objects as parameters to methods. Please refer to below example for explanation
        Test ob1 = new Test(100, 2);
        Test ob2 = new Test(100, 2);
        Test ob3 = new Test(10, 2);

        System.out.println("Is ob1 == ob2? " + ob1.isEqualTo(ob2));
        System.out.println("is ob1 == ob3? " + ob1.isEqualTo(ob3));
    }
}

class Test {
    int a, b;

    Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    boolean isEqualTo(Test o) {
        return (this.a == o.a) && (this.b == o.b);
    }
}
