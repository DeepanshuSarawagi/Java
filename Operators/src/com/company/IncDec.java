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

        // Now let's consider below example with respect to postfix increment.

        x = 42;
        y = x++;
        System.out.println("x is now: " + x);
        System.out.println("y is now: " + y);

        // This is similar to below lines of code
        // first b is assigned to a and then a is incremented by 1
        // y = x;
        // x = x+ 1;

        // in both the cases, be it prefix or postfix increment, x is incremented to 43 but the value of y depends on
        // the type of increment.

    }
}
