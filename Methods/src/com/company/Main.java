package com.company;

public class Main {

    public static void main(String[] args) {

        int level = 5;
        int bonus = 100;

        int highScore = calculateScore(true, 5000, level, bonus);
        System.out.println("Your final score is: " + highScore);

        highScore = calculateScore(true, 10000, 8, 200);
        System.out.println("Your final score is: " + highScore);

        String playerName = "Deepanshu";
        int playerScore = 1500;
        int position = calculateHighScorePosition(playerScore);
        displayHighScorePosition(playerName, position);

        playerName = "Rajat";
        playerScore = 900;
        position = calculateHighScorePosition(playerScore);
        displayHighScorePosition(playerName, position);

        playerName = "Divya";
        playerScore = 400;
        position = calculateHighScorePosition(playerScore);
        displayHighScorePosition(playerName, position);

        playerName = "Pooja";
        playerScore = 50;
        position = calculateHighScorePosition(playerScore);
        displayHighScorePosition(playerName, position);
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

    // Udemy challenge
    // Create a method called displayHighScorePosition
    // it should a players name as a parameter, and a 2nd parameter as a position in the high score table
    // You should display the players name along with a message like " managed to get into position " and the
    // position they got and a further message " on the high score table".
    //
    // Create a 2nd method called calculateHighScorePosition
    // it should be sent one argument only, the player score
    // it should return an in
    // the return data should be
    // 1 if the score is >=1000
    // 2 if the score is >=500 and < 1000
    // 3 if the score is >=100 and < 500
    // 4 in all other cases
    // call both methods and display the results of the following
    // a score of 1500, 900, 400 and 50
    //

    public static void displayHighScorePosition(String playerName, int position){
        System.out.println("Player " + playerName + " managed to get into position " + position + " on the high " +
                "score table");
    }
    public static int calculateHighScorePosition(int playerScore){
        if (playerScore >=1000){
            return 1;
        } else if(playerScore >= 500 && playerScore < 1000){
            return 2;
        } else if(playerScore >= 100 && playerScore < 500){
            return 3;
        }
        return 4;
    }
}
