package com.company;

public class IncDec {

    public static void main(String[] args) {
        // we are going to learn about the increment and decrement in prefix and postfix form.
        // lets consider the below code.

        int x = 42;
        int y;

        y = ++x;

        // What happened here is that before the x is assigned to y, x is incremented by 1. Below operations take place
        // x = x + 1;
        // y = x;
        // This is an example of prefix increment
        System.out.println("x is now: " + x);
        System.out.println("y is now: " + y);

    }
}
