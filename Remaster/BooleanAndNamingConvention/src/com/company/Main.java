package com.company;

public class Main {

    public static void main(String[] args) {
        int score = 800;
	    boolean isGameOver = true;
	    int levelCompleted = 5;
	    int bonus = 100;

	    if (isGameOver) {
	        int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }
}
