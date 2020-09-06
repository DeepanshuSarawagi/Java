package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Use the logical operators in the RegEx
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        String string = "IHaveAaaString";
        System.out.println(string.replaceAll("[A|a]", "Y"));
        Pattern pattern = Pattern.compile("a", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        matcher.reset();

        if (matcher.matches()) {
            System.out.println(string.replaceAll(pattern.toString(), "YY"));
//            System.out.println(matcher.replaceAll("YY"));
        }

        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";  // Here we are using the Negative look ahead expression which says that the
        // character need not necessarily consume characters
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);
        int count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence: " + count + " " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }
    }
}
