package com.company;

public class Main {

    public static void main(String[] args) {

        int level = 5;
        int bonus = 100;

        int highScore = calculateScore(true, 5000, level, bonus);
        System.out.println("Your final score is: " + highScore);

        highScore = calculateScore(true, 10000, 8, 200);
        System.out.println("Your final score is: " + highScore);
    }

    public static int calculateScore(boolean gameOver, int score, int level, int bonus) {
        // we use void in the method if we don't want method to return anything
        // here, we are trying to return data which is of type int hence change the void keyword to int

        if (gameOver) {
            int finalScore = level * bonus + score;
            finalScore += 1000;
            return finalScore;
        }
        return  -1;
    }
}
