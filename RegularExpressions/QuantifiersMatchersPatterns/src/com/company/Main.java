package com.company;

public class Main {

    public static void main(String[] args) {
        String alphaNumeric = "abcDeeeeFg111hiiiiiJk910Xy";
        System.out.println(alphaNumeric.replaceAll("^abcDe{4}", "X"));
        // We use the quantifiers in the regEx. It is helpful to specify the exact count of preceding character which
        // match in the String.
        // A Quantifier specifies how often an element in a regular expression can occur

        // In the below example we will use the + quantifier which requires us not to specify the exact number of
        // occurrences of an element in the regular expression

        System.out.println(alphaNumeric.replaceAll("^abcDe+", "X"));
    }
}
