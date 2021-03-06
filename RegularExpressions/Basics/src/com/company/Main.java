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

        // We use the Dollar Boundary Matcher to replace the specific number of characters towards the end of the
        // String. The end of the String must match exactly the RegEx will be passed as parameter in the
        // String.replaceAll() method

        System.out.println(alphaNumeric.replaceAll("90xyZ$", "TheEnd"));  // notice the Dollar at the
        // end of the RegEx

        // To replace the specific set of characters in the String, we need to pass the RegEx in square brackets and it
        // will replace all the occurrences of characters passed as RegEx in the String.
        // In the below example, we will replacing all the occurrences of "abi" in the alphaNumeric String

        System.out.println(alphaNumeric.replaceAll("[abi]", "X"));  // This doesnt look for a patter
        // "abi", instead it looks for any character which matches a/b/i

        System.out.println(alphaNumeric.replaceAll("[aei][FJ]", "X"));  // This is going to replace
        // any letter a, e or i which is followed by F or J with X

    }
}
