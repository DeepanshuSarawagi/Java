package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {
    public static void main(String[] args) {
        StringBuilder htmlText = new StringBuilder("<h1>My heading</h1>");
        htmlText.append("<h2>Sub-Heading</h2>");
        htmlText.append("<p>This is a paragraph about something!");
        htmlText.append("<h2>Another Sub-Heading</h2>");
        htmlText.append("<p>This is another paragraph about something else</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>This is the Summary</p>");

        System.out.println(htmlText);

        String h2Pattern = ".*<h2>.*";   // the dot character class will match every character and * quantifier will
        // look for the number of <h2> occurrences in the String

        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);  // Make the pattern case insensitive
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        // In this example we will find exact occurrence of "<h2>" pattern in the String.

        String anotherH2Pattern = "<h2>";  // Since we are finding the pattern in the String in parts and not as an
        // entire text, we need not use the dot Character class in the RegEx.

        Pattern pattern1 = Pattern.compile(anotherH2Pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(htmlText);
        System.out.println(matcher1.matches());
        matcher1.reset();  // Since the Matcher.matches() method, updates the internal state of the matcher, we need to
        // reset its state by calling the Matcher.reset() method.
        // Remember that matcher.end() returns the character of first index position after the match is complete.

        int count =0;
        while (matcher1.find()) {
            count++;
            System.out.println("Occurrence " + count + ": " + matcher1.start() + " to " + matcher1.end());
        }


    }
}
