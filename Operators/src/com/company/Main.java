package com.company;


public class Main {

    public static void main(String[] args) {

        int result = 1 + 2;
        System.out.println("1 + 2 = " + result);
        int previousResult = result;
        System.out.println("Previous result is = " + previousResult);
        result -= 1;
        System.out.println("Result's new value is: " + result);
        result *= 10;
        System.out.println("Result is now: " + result);

        double resultDouble = (result / 3d);
        System.out.println("ResultDouble is: " + resultDouble);

        result = result % 3;
        System.out.println("Result is now: " + result);

        // == operator
        boolean isAlien = false;
//        if (isAlien == false)
        if (!isAlien) {
            System.out.println("It is not an alien");
            System.out.println("And I'm not scared of aliens either!");
        }

        System.out.println();

        int topScore = 80;
        if (topScore >= 100) {
            System.out.println("You have got the highest marks!");
        }
        else {
            System.out.println("You have got good marks");
        }

        System.out.println();

        int secondTopScore = 60;
        if (topScore > secondTopScore && topScore < 100){
            System.out.println("You have got the top score but less than 100");
        }
    }
}
