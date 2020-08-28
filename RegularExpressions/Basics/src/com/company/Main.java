package com.company;

public class Main {

    public static void main(String[] args) {
        String string = "I am a String. Yes, I am!";
        System.out.println(string);

        // Convert all the occurrences of "I" with "You"

        String youString = string.replaceAll("I", "You");
        System.out.println(youString);

        // We are going to Character Class to replace the entire string with "Y"

        String alphaNumeric = "abcDeeeFG20FghiiiiJKL90xyZ";
        System.out.println(alphaNumeric.replaceAll(".", "Y"));

        // We will use the caret boundary matcher to replace the characters in a String with desired String.
        // In this case we have to ensure that the caret boundary matcher regex provided should exactly match the
        // beginning of the string on which this operation is being performed

        System.out.println(alphaNumeric.replaceAll("^abcDeee", "YYY"));
        String secondString = "abcDeeeFG20FghiiiiabcDeeeJKL90xyZ";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));  // note that this replace
        // the matched RegEx only in the beginning of the string and not the second occurrence

        // Use the String.matches() method to check if the RegEx passed as an argument in the method matches the
        // beginning of the string

        System.out.println(alphaNumeric.matches("^hello"));  // This is will return false
        System.out.println(alphaNumeric.matches("^abcDeee"));  // This is will return false since we need to pass
        // the entire string as RegEx
        System.out.println(alphaNumeric.matches("^abcDeeeFG20FghiiiiJKL90xyZ"));  // This will return true
    }
}
