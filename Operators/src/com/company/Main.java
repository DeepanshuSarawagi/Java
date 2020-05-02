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
        // Logical AND operator
        int secondTopScore = 60;
        if (topScore > secondTopScore && topScore < 100){
            System.out.println("You have got the top score but less than 100");
        }

        // Logical OR operator
        System.out.println();
        if (topScore > 90 || secondTopScore <= 90){
            System.out.println("Either or both of the conditions are true");
        }
        // Logical NOT operator
        System.out.println();
        boolean isCar = false;
        if (isCar == true){  // This is the most common mistake one does in Java. We need to always
                            // use the equal to operator and not the assignment operator
                            // please refer to the correct code below
            System.out.println("This is not supposed to happen");
        }
        System.out.println();
        boolean isCar1 = false;  // reassign the variable since previous boolean value of isCar
                                 // is set to true on line 56
        if (!isCar1){
            System.out.println("You have got it right. It is not a Car.");
        }
        if (isCar1 == false) {
            System.out.println("You have got it right. It is not a Car.");
        }
        boolean wasCar = isCar ? true : false;
        if (wasCar){
            System.out.println("wasCar is true");
        }
        System.out.println();
        int ageOfClient = 20;
        boolean isEighteenOrOver = ageOfClient == 20 ? true : false;
        if (isEighteenOrOver){
            System.out.println("Yes the client is eighteen or over");
        }

        // Udemy challenge on the operator precedence

        double firstVariable = 20.00;
        double secondVariable = 80.00;
        double resultNow = (firstVariable + secondVariable) * 100;
        double remainder = resultNow % 40.00;
        System.out.println(remainder);
        boolean isRemainder = remainder == 0d ? true : false;
        System.out.println("Is remainder = " + isRemainder);
        if(!isRemainder){
            System.out.println("Got some remainder");
        }

        BitwiseOperators.bitwiseNot();
    }
}

class BitwiseOperators{
    public static void bitwiseNot() {
        int a = 42;
        int b = 15;
        System.out.println("Bitwise And of a & b: " + (a&b));
        System.out.println("Bitwise OR of a | b is: " + (a|b));
        System.out.println("Bitwise XOR of a ^ b is: " + (a^b));

    }
}
