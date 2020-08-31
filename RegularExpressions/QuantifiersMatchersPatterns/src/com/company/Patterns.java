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

        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());
    }
}
