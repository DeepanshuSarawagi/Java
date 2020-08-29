package com.deepanshu;

public class Main {
    public static void main(String[] args) {
        // In the below example we will see how to replace the word with Upper/Lower case first letter with another
        // word

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        // Below is the example on how to convert every character in the String except the characters "'e' and 'j'"

        String alphaNumeric = "abcDeeeeF103iiiiiJEEkllll910xyz";

        System.out.println(alphaNumeric.replaceAll("[^eEJ]", "X"));  // This will replace all the
        // characters in the String except e, E, J
    }
}
