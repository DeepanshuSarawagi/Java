package com.company;

public class methodChallenge {
    public static void main(String[] args) {
        int playerScore = calculateHighScorePosition(1500);
        displayHighScorePosition("Deepanshu", playerScore);

        displayHighScorePosition("Deepanshu", calculateHighScorePosition(900));
        displayHighScorePosition("Deepanshu", calculateHighScorePosition(400));
        displayHighScorePosition("Deepanshu", calculateHighScorePosition(50));

    }

    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println(playerName + " managed to get position " + position + " in the high score table");
    }

    public static int calculateHighScorePosition(int score) {
        if (score >= 1000) {
            return 1;
        } else if ((score >= 500) && (score < 1000)) {
            return 2;
        } else if ((score >=100) && (score < 500)) {
            return 3;
        }
        return 4;
    }
}
