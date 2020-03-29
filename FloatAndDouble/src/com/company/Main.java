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

        int myIntValue = 5;
        float myFloatValue = 5.25f;
        double myDoubleValue = 5.25d;

        System.out.println(myIntValue + myFloatValue + myDoubleValue);

    }
}
