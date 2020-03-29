package com.company;

public class Main {

    public static void main(String[] args) {

        char myChar = 'D';
        // char is yet another data type which is used to store single charater in single quotes
        System.out.println("The char is:  " + myChar);
        // lets print the equivalent unicode value of character D
        char myUnicodeCharValue = '\u0044';
        System.out.println(myUnicodeCharValue);
        char myOtherChar = '\u0926';
        System.out.println(myOtherChar);

        // /u stands for unicode. It should be a four digit unicode

        boolean myTrueBooleanValue = true;
        boolean myFalseBooleanValue = false;

        System.out.println(myTrueBooleanValue);
        System.out.println(myFalseBooleanValue);

        boolean isCustomerOverTwentyOne = true;
        System.out.println(isCustomerOverTwentyOne);

    }
}
