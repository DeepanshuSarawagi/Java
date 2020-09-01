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

        // We will now be learning about matcher.group() method which will help us to find the pattern in the String
        // or any given text.

        String groupH2Pattern = "(<h2>)";   // to use a group in the RegEx we use the parenthesis. Hence, we surrounded
        // the regEx with parenthesis.
        Pattern groupPattern = Pattern.compile(groupH2Pattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));  // We need start counting the groups from
            // number 1 when we want to access them. Group 0 is the entire character sequence.
            // Hence, we have passed the parameter 1 in the .group() method.

        }
        System.out.println();

        // In the below example, we are learning the difference between greedy quantifier and lazy/reluctant quantifier

        groupH2Pattern = "(<h2>.*</h2>)";  // This will grab everything from opening tag of <h2> and closing tag of
        // </h2>. The * or asterisk quantifier acts as a greedy quantifier and it grabs every characters required for a
        // match

        groupPattern = Pattern.compile(groupH2Pattern);
        groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        // We will now turn a greedy quantifier to a lazy quantifier. The moment it matches the pattern in the text, it
        // will grabbing the characters from the text. We can convert a greedy quantifier to a lazy quantifier by adding
        // a ? mark after the * asterisk

        System.out.println();
        groupH2Pattern = "(<h2>.*?</h2>)";   // This will convert the greedy quantifier to lazy/reluctant quantifier
        groupPattern = Pattern.compile(groupH2Pattern);
        groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        System.out.println();

        // If we want to grab the text between the HTML tags, then we can use the multiple groups in the Pattern

        String H2TextGroups = "(<h2>)(.+?)(</h2>)";  // Here we are using three groups. The dot character class accounts
        // for all the characters in the string/text. The + quantifier looks for at least 1 or more characters after the
        // <h2> tag and before </h2> tag. The ? quantifier is the reluctant quantifier

        Pattern H2TextPattern = Pattern.compile(H2TextGroups);
        Matcher H2TextMatcher = H2TextPattern.matcher(htmlText);

        while (H2TextMatcher.find()) {
            System.out.println("Occurrence: " + H2TextMatcher.group(2));  // This time we are using the second group
            // since we want to just grab the text between the <h2> HTML tags
        }
    }
}
