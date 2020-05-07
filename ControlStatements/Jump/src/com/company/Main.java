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

        // While using break, it breaks out of only the innermost loop if used in a nested loop.
        // Look at the preceeding example for better understanding.

        for (int i = 0; i < 4; i++) {
            System.out.print("Pass " + i + ": ");
            for (int j =0; j<100; j++) {
                if (j == 10) {
                    break;  // only the inner loop breaks
                }
                System.out.print(j + " " );
            }
            System.out.println();
        }
    }
}
