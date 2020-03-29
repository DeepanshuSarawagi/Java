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

    }
}
