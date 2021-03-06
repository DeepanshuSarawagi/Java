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
        // Look at the preceding example for better understanding.

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

        /*
        break statement can also be used as a civilized form of GOTO statement in Java. Although, unlike other languages
        Java doesn't doesn`t have a GOTO keyword, break can be used as a GOTO form. This block of code need not be any
        switch or other loops, they can be any form of labeled block of code. Label is the block of code that identifies
        name of the block. The labeled block must enclose the break statement. This should not be a immediate block
        of code, instead it can be used in any block of nested blocks of code. When using the break in a nested block of
        code, you can resume the execution of code from a certain block, you can cannot use it to transfer control out of
        block.
        To name a block, put a lable at start of it. Then use this lable as target block with break statement.
        Consider the below example
         */
        boolean t = true;
        first: {
            second: {
            third: {
                System.out.println("Before the break");
                if (t) {
                    break second;
                }
                System.out.println("this won't execute");
            }
                System.out.println("This wont execute either");
            }
            System.out.println("This will execute");
        }

        // one more example
        outer: for (int i = 0; i < 4; i++) {
            System.out.print("Pass " + i + ": ");
            for (int j =0; j<100; j++) {
                if (j == 10) {
                    break outer;  // this will break out of the outer for itself since we have asked to do so.
                }
                System.out.print(j + " " );
            }
            System.out.println();
        }

        System.out.println();
        // Use continue to skip the remaining iteration of loop or remaining execution of code.

        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (j>i) {
                    continue;
                }
                System.out.print(" " + (i*j));
            }
            System.out.println();
        }

        // one more example of using continue
        for (int i=0; i<10; i++) {
            System.out.print(i + " ");
            if (i%2 == 0) {
                continue;
            }
            System.out.println();
        }

        // The return statement is explicitly used to return from a method. That is it causes program control to
        // transfer back to the caller of the method.

        t = true;
        System.out.println("Before the return");
        if (t) return;
        System.out.println("This wont execute");
    }
}
