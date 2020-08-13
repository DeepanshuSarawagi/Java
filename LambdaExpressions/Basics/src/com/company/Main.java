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
         */
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the runnable");
    }
}
