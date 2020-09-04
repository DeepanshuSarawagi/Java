package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Use the logical operators in the RegEx
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        String string = "IHaveAString";
        Pattern pattern = Pattern.compile("[a|A]");
        Matcher matcher = pattern.matcher(string);

        if (matcher.matches()) {
            System.out.println(string.replaceAll("[^a|A]", "YY"));
        }
    }
}
