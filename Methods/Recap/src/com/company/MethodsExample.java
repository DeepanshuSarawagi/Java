package com.company;

public class MethodsExample {
    public static void main(String[] args) {
        int score = calculateScore(1000, true, 5, 200);
        System.out.println("Your final score is: " + score);
        score = calculateScore(1000, false, 5, 200);
        System.out.println("Your final score is: " + score);
    }
    public static int calculateScore(int score, boolean isAlive, int levelCompleted, int bonus) {
        int finalScore;
        if (isAlive) {
            finalScore = score + (levelCompleted * bonus);
        } else {
            finalScore = score;
        }
        return finalScore;
    }
}
