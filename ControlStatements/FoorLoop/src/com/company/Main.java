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

        }

    public static double calculateInterestRate(double amount, double interestRate){
        return (amount * (interestRate / 100));
    }

    // revisit for-loop for more learning
}
