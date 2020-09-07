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
        String Challenge4 = "Replace all the blanks with underscores";
        System.out.println(Challenge4.replaceAll("\\s", "_"));
    }
}
