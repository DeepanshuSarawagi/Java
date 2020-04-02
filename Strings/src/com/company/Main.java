package com.company;

public class Main {

    public static void main(String[] args) {
        // byte
        // int
        // short
        // long
        // float
        // double
        // char
        // boolean

        String myStringValue = "Deepanshu";
        System.out.println(myStringValue);
        System.out.println(myStringValue.length());
        myStringValue = myStringValue + ", and I`m learning Java.";
        System.out.println(myStringValue);
        myStringValue = myStringValue + " \u00A9 2020.";
        System.out.println(myStringValue);

        // String is not a primitive datatype. Its a class.

        double floatNumber = 3.1567;
        int intNumber = (int) (floatNumber);
        System.out.println(intNumber);
        double decimalNumber = (floatNumber % intNumber);
        System.out.println(decimalNumber);
        int intNumber2 = -3;
        System.out.println((intNumber == intNumber2));

    }

}
