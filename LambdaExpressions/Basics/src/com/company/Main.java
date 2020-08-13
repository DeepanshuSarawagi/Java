package com.company;

public class Main {

    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the Runnable");
//            }
//        }).start();

        // Commented out above code to use Lambda Expressions in below example
        new Thread(()-> System.out.println("Printing from the Runnable")).start();
        /*
        Every Lambda Expression consists of three parts.
            1. Argument list - ()
            2. Error Token - ->
            3. Body  - System.out.println("Printing from the Runnable")

        How does the Lambda Expression evaluate the above code? In this case, the Lambda Expressions checks for the
        parameter which is accepted by the Thread class constructor which is the Runnable interface. And this
        Runnable interface implements just one method which is run() and it has no arguments. Hence, the empty
        Argument List is evaluated against the Runnable Interface.
        Since the Lambda Expressions looks out for methods, it can only be replaced against the interface with just one
        method, also referred to as Functional Interfaces.
         */
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the runnable");
    }
}
