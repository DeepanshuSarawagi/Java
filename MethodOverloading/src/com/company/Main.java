package com.company;

public class Main {

    public static void main(String[] args) {
        int newScore = calculateScore("Deepashu", 500);
        System.out.println("New score is " + newScore);
        int newScoreOfUnnamedPlayer = calculateScore(5000);
        System.out.println(newScoreOfUnnamedPlayer);
        calculateScore();

        System.out.println();

        double cm = calcFeetAndInchesToCentimeters(10, 12);
        System.out.println(cm);

        double centimeters = calcFeetAndInchesToCentimeters(100);
        System.out.println(centimeters);
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

        /* The code on line 35 to 37 will throw an error. We cannot overload an method by changing the datatype of the
        return value of a method. To overload a method, we need to define unique parameters. This is called as changing
        the signature of the method so that we can overload it.
         */

        // Calculate feet and inches to centimeters challenge on Udemy

    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if (feet >= 0){
            if (inches >=0 && inches <=12) {
                double feetToInches = feet * 12;
                return (inches + feetToInches) * 2.54;
            }
            System.out.println("Invalid feet or inches");
        }

        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0) {
            return -1;
        }

        int feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        System.out.println(inches + " Inches" + " has " + feet + " feet and " + remainingInches + " inches");
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }

}
