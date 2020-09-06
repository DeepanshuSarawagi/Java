package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Use the logical operators in the RegEx
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        String string = "IHaveAaaString";
        System.out.println(string.replaceAll("[A|a]", "Y"));
        Pattern pattern = Pattern.compile(".*A.*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        matcher.reset();

        if (matcher.matches()) {
            System.out.println(string.replaceAll(pattern.toString(), "YY"));
//            System.out.println(matcher.replaceAll("YY"));
        }
    }
}
