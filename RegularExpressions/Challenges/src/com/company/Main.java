package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	    String string1 = "I want a bike.";

        System.out.println(string1.matches("I want a bike."));
        String regEx = "I want a \\w+.";
        System.out.println(string1.matches(regEx));
        String challenge2 = "I want a ball.";
        System.out.println(challenge2.matches(regEx));
        System.out.println(string1.replaceAll("bike.$", "ball."));

        // Challenge3
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string1);
        System.out.println(matcher.matches());
        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());

        //Challenge4 replace all the blanks with underscores
        String challenge4 = "Replace all the blanks with underscores";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        //Challenge5 Match the below String in entirety
        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("^[a]{3}[b][c]{8}[d]{3}[e][f]{3}[g]$"));  // This is solution to
        // challenge6

        System.out.println(challenge5.matches("[a-g]+"));  // Concise way of solving the challenge 5
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "REPLACED"));

        // Challenge7 - Test the below Alphanumeric string
        String challenge7 = "aAbcd.135";
        System.out.println(challenge7.matches("^(?i)[a-z]+[.]\\d+$"));

        // Challenge8 - Print all the occurrences of Numeric characters in the below String

        String challenge8 = "abcd.135uvqz.7tzik.999";
        String challenge8RegEx = "(\\d+)";
        Pattern pattern1 = Pattern.compile(challenge8RegEx);
        Matcher matcher1 = pattern1.matcher(challenge8);

        int count = 0;
        while (matcher1.find()) {
            count++;
            System.out.println("Occurrence " + count + ": " + matcher1.group(1));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern9 = Pattern.compile("(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);

        while (matcher9.find()) {
            System.out.println("Occurrence: " + matcher9.group(1));
        }

        //challenge 10 - print the indices
        matcher9.reset();

        while (matcher9.find()) {
            System.out.println("Occurrence " + matcher9.start(1) + " end: " + (matcher9.end(1) -1));
        }

        // Challenge 11 - Extract what's in the curly braces

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern pattern11 = Pattern.compile("(\\{)(.+?)(})");
        Matcher matcher11 = pattern11.matcher(challenge11);

        while (matcher11.find()) {
            System.out.println("Occurrence: " + matcher11.group(2));
        }

        // Challenge 12 - Write a RegEx which will match the 5 digit US Zip code

        System.out.println("11111".matches("^\\d{5}$"));

        // Challenge 13 - Write the RegEx to match the US Zip code which has following format "11111-1111"

        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^([\\d]{5}[\\-][\\d]{4}?)$"));

        // Challenge 14 - Write the RegEx that will match the US zip code with optional four digits after dash

        String challenge14RegEx = "^\\d{5}(-\\d+)?$";
        System.out.println(challenge13.matches(challenge14RegEx));
        System.out.println("11111".matches(challenge14RegEx));
        System.out.println("testing: " + "34561-4980".matches("^\\d{5}(-\\d+)?$"));
    }
}
