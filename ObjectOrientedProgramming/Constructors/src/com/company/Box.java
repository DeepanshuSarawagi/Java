package com.company;

import org.w3c.dom.ls.LSOutput;

public class Box {
    private double width;
    private double height;
    private double depth;

    Box() {
        System.out.println("Constructing box with default values..");
        this.width = 10;
        this.height = 10;
        this.depth = 10;
    }

    // Overloading a constructor
    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    double volume() {
        return width*height*depth;
    }

}

class BoxDemo6{
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();

        // Creating new object/instance of class Box using its overloaded Contructor (Constructor with parameter)

        Box box3 = new Box(15, 23, 31);

        System.out.println("Volume of box1 is: " + box1.volume());
        System.out.println("Volume of box2 is: " + box2.volume());
        System.out.println("Volume of box3 is: " + box3.volume());
    }
}

class Stack {
    int[] stck = new int[10];
    int tos;

    public Stack() {
        tos = -1;
    }

    void push(int item) {
        if (tos == 9) {
            System.out.println("Stack is full");
        } else {
            stck[++tos] = item;
        }
    }

    int pop() {

        if (tos < 0) {
            System.out.println("Stack underflow");
            return 0;
        }
        return stck[tos--];
    }
}

class TestStack {
    public static void main(String[] args) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        // Push some item in stack

        for (int i =0; i<10;i++) {
            stack1.push(i);
        }
        for (int i=10; i<20; i++) {
            stack2.push(i);
        }

        // pop these items from the stack
        System.out.println("Items in stack1 are: ");
        for (int i=0; i<stack1.stck.length; i++) {
            System.out.println(stack1.pop());
        }
        System.out.println("Items in stack2 are: ");
        for (int i=0; i<stack2.stck.length; i++) {
            System.out.println(stack2.pop());
        }
    }
}
