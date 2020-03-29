package com.company;

public class Main {

    public static void main(String[] args) {

        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;

        System.out.println("The Minimum float value is: " + myMinFloatValue);
        System.out.println("The Maximum float value is " + myMaxFloatValue);

        System.out.println();

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;

        System.out.println("The Minimum double value is: " + myMinDoubleValue);
        System.out.println("The Maximum double value is " + myMaxDoubleValue);

        int myIntValue = 5 / 3;
        float myFloatValue = 5f / 3f;
        double myDoubleValue = 5d / 3d;

        System.out.println("My Int Value " + myIntValue);
        System.out.println("My float Value " + myFloatValue);
        System.out.println("My double value " + myDoubleValue);

        // modern computers are designed in such a way to process the double floating point number
        // much faster than the float. It is highly recommended to use double while creating java classes
        // since most of the java libraries use double floating point number

        // Udemy simple challenge to convert pounds to kilogram

        int poundValue = 200;
        double kgValue = poundValue * 0.45359237;
        System.out.println( poundValue + " pounds converted to Kg is: " + kgValue);


    }
}
