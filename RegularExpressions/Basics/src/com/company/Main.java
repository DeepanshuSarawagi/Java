package com.company;

public class Main {

    public static void main(String[] args) {
        String string = "I am a String. Yes, I am!";
        System.out.println(string);

        // Convert all the occurrences of "I" with "You"

        String youString = string.replace("I", "You");
        System.out.println(youString);
    }
}
