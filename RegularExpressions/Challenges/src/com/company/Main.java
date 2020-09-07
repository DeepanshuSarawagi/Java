package com.company;

public class Main {

    public static void main(String[] args) {
	    String string1 = "I want a bike.";

        System.out.println(string1.matches("I want a bike."));
        String regEx = "I want a \\w+.";
        System.out.println(string1.matches(regEx));
        String challenge2 = "I want a ball.";
        System.out.println(challenge2.matches(regEx));
        System.out.println(string1.replaceAll("bike.$", "ball."));
    }
}
