package com.company;

public class MethodsExample {
    public static void main(String[] args) {
        calculateScore(1000, true, 5, 200);
    }
    public static void calculateScore(int score, boolean isAlive, int levelCompleted, int bonus) {
        if (isAlive) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score is: " + finalScore);
        } else {
            System.out.println("Your final score is: " + score);
        }
    }
}
