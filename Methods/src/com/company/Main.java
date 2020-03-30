package com.company;

public class Main {

    public static void main(String[] args) {

        int level = 5;
        int bonus = 100;

        calculateScore(true, 5000, level, bonus);

        calculateScore(true, 10000, 8, 200);
    }

    public static void calculateScore(boolean gameOver, int score, int level, int bonus) {

        if (gameOver) {
            int finalScore = level * bonus + score;
            finalScore += 1000;
            System.out.println("You final score is: " + finalScore);
        }
    }
}
