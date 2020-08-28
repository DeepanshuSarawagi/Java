package com.company;

public class Main {

    public static void main(String[] args) {
        String string = "I am a String. Yes, I am!";
        System.out.println(string);

        // Convert all the occurrences of "I" with "You"

        String youString = string.replace("I", "You");
        System.out.println(youString);

        // We are going to Character Class to replace the entire string with "Y"

        String alphaNumeric = "abcDeeeFG20FghiiiiJKL90xyZ";
        System.out.println(alphaNumeric.replaceAll(".", "Y"));

        // We will use the caret boundary matcher to replace the characters in a String with desired String.
        // In this case we have to ensure that the caret boundary matcher regex provided should exactly match the
        // beginning of the string on which this operation is being performed

        System.out.println(alphaNumeric.replaceAll("^abcDeee", "YYY"));
    }
}
