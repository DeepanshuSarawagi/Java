package com.company;

public class Main {

    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 5000;
        int level = 5;
        int bonus = 100;

        calculateScore(true, 5000, level, bonus);

        score = 10000;
        level = 8;
        bonus = 200;
        if (gameOver) {
            int finalScore = level * bonus + score;
            System.out.println("You final score is: " + finalScore);
        }
    }

    public static void calculateScore(boolean gameOver, int score, int level, int bonus) {

        if (gameOver) {
            int finalScore = level * bonus + score;
            finalScore += 1000;
            System.out.println("You final score is: " + finalScore);
        }
    }
}
