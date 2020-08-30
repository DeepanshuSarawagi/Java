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
        // The above RegEx [^eEJ] is not the boundary matcher. Instead since we are using the caret boundary matcher in
        // the square brackets, it will negate the matching. As in, it will not match the characters e, R or J in the
        // string and replace everything else with the Replacement

        // Below is the example if we want to replace the characters "a,b,c,d,e,f" and numerics "6,7,8,9,0" inclusive

        System.out.println(alphaNumeric.replaceAll("[abcdef67890]", "X"));
        System.out.println(alphaNumeric.replaceAll("[a-f6-90]", "X"));  // Shorter of achieving the
        // same result as above

        System.out.println(alphaNumeric.replaceAll("[a-fA-F06-9]", "X"));  // Will replace any
        // characters between a through f and 6 through 9 and 0 irrespective of case sensitive

        // Use the special construct to turn off case sensitivity. We use the ?i in parenthesis to turn off the case
        // sensitivity

        System.out.println(alphaNumeric.replaceAll("(?i)[a-f06-9]", "X"));

        // Below is the example how to replace all the numeric characters in the String
        System.out.println(alphaNumeric.replaceAll("[0-9]", "X"));
        System.out.println(alphaNumeric.replaceAll("\\d", "X"));  // shorthand way to replace all the
        // numeric characters in the string using character class

        System.out.println(alphaNumeric.replaceAll("\\D", "X"));  // This replaces all the
        // non-numeric from the String

        String hasWhiteSpace = "I have whiteSpaces and a \t tab, also a newline \n";
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));  // Character class to remove all the
        // blank space from the string
        System.out.println(alphaNumeric.replaceAll("\\w", "X"));  // This will replace all the
        // alphanumeric characters from the String
        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));  // Surrounds every word with the
        // replacement string. This will be helpful when you want to create a HTML doc
    }
}
