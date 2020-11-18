package com.company;

public class StatementsExample {
    public static void main(String[] args) {

        int finalScore = 50;  // This is a declaration statement expression
        finalScore++; // This is an expression statement
        System.out.println(finalScore);

        // Assignment expression
        finalScore = 60;
        System.out.println(finalScore);

        int playerLives = 3;
//        playerLives--;
        System.out.println("Player Lives = " + playerLives--);  // In this case, the playerLives value in the output
        // would be 3 because decrement is postfix and output statement was executed first
        System.out.println("Updated player lives = " + playerLives);

        // prefix increment or decrement
        System.out.println("Player lives after prefix decrement is = " + --playerLives);
    }
}
