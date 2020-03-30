package com.company;

public class Main {

    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 5000;
        int level = 5;
        int bonus = 100;

        calculateScore();

        score = 10000;
        level = 8;
        bonus = 200;
        if (gameOver) {
            int finalScore = level * bonus + score;
            System.out.println("You final score is: " + finalScore);
        }
    }

    public static void calculateScore() {

        boolean gameOver = true;
        int score = 5000;
        int level = 5;
        int bonus = 100;

        if (gameOver) {
            int finalScore = level * bonus + score;
            System.out.println("You final score is: " + finalScore);
        }
    }
}
