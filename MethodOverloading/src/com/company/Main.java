package com.company;

public class Main {

    public static void main(String[] args) {
        int newScore = calculateScore("Deepashu", 500);
        System.out.println("New score is " + newScore);
        int newScoreOfUnnamedPlayer = calculateScore(5000);
        System.out.println(newScoreOfUnnamedPlayer);
        calculateScore();
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " has scored " + score + " points");
        return score * 100;
    }

    public static int calculateScore(int score) {  // overloading the method by using the same name but different params
        System.out.println("Unnamed Player " + "has scored " + score + " points");
        return score * 100;
    }

    public static void calculateScore() {  // overloading the method by using the same name but different params
        System.out.println("No Player, No Score " );
    }

//    public static int calculateScore() {
//        System.out.println("No Player, No Score ");
//        return 0;

        /* The code on line 27 to 29 will throw an error. We cannot overload an method by changing the datatype of the
        return value of a method. To overload a method, we need to define unique parameters. This is called as changing
        the signature of the method so that we can overload it.
         */

}

