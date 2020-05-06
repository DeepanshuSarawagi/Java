package com.company;

public class Main {

    public static void main(String[] args) {
	// Basic for loop

        for (int i =0; i < 6; i++){
            System.out.println("Loop " + i + " hello");

        }

        for (double i = 2; i < 9; i++){
            System.out.println(i + " % Interest on amount 10000 is " + calculateInterestRate(10000.0, i));
        }

        for (double i = 8; i >1; i--){
            System.out.println(i + " % Interest on amount 10000 is " + calculateInterestRate(10000.0, i));
        }

        // revisit for-loop for more learning
        // let's consider the following program for example
        int a, b;
        b = 4;
        for (a = 1; a<b; a++) {
            System.out.println("a is "  + a);
            System.out.println("b is " + b);
            b--;
        }
        // instead of controlling the for loop manually by decrementing the value of b, Java provides a provision to do
        // that inside for loop. You can initialise and iterate multiple variables inside a for loop using comma as
        // separator. Above programm can be re-written like this.
        System.out.println("=================");
        for (a=1, b=4; a<b; a++, b--) {
            System.out.println("a is "  + a);
            System.out.println("b is " + b);
        }

        }

    public static double calculateInterestRate(double amount, double interestRate){
        return (amount * (interestRate / 100));
    }


}
