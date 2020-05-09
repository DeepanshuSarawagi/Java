package com.company;

public class Main {

    public static void main(String[] args) {
	    // We can also pass objects as parameters to methods. Please refer to below example for explanation
        Test ob1 = new Test(100, 2);
        Test ob2 = new Test(100, 2);
        Test ob3 = new Test(10, 2);

        System.out.println("Is ob1 == ob2? " + ob1.isEqualTo(ob2));
        System.out.println("is ob1 == ob3? " + ob1.isEqualTo(ob3));

        // Creating new objects of class objects

        Box box1 = new Box(15, 20, 35);
        Box box2 = new Box(24.9);
        Box box3 = new Box(box1);  // Passing the object box1 as a parameter to create new object box3.
                                   // technically box1 and box3 would have different memory allocations when box3 object
                                   // is created during run time.

        System.out.println("Volume of box1 is " + box1.volume());
        System.out.println("Volume of box2 is " + box2.volume());
        System.out.println("Volume of box3 is " + box3.volume());
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

class Box{
    private double width;
    private double height;
    private double depth;

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box(Box box) {
        this.width = box.width;
        this.height = box.height;
        this.depth = box.depth;
    }

    public Box(double len) {
        this.width = this.height = this.depth = len;
    }

    double volume() {
        return this.width*this.height*this.depth;
    }
}