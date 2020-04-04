package com.company;

public class Main {

    public static void main(String[] args) {
        int newScore = calculateScore("Deepashu", 500);
        System.out.println("New score is " + newScore);
        int newScoreOfUnnamedPlayer = calculateScore(5000);
        System.out.println(newScoreOfUnnamedPlayer);
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " has scored " + score + " points");
        return score * 100;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed Player " + "has scored " + score + " points");
        return score * 100;
    }
}
