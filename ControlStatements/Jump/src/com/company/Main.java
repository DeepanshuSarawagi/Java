package com.company;

public class Main {

    public static void main(String[] args) {
	    // Java supports three jump statements continue, break and return.
        // These statements transfer control to other parts of program.

        // By using break we can force termination of the loop bypassing the conditional expression and any block of
        // remaining code in the body.

        for (int i =0; i<100; i++) {
            if (i==10) {
                break;
            }
            System.out.println("i is " + i);
        }
    }
}
