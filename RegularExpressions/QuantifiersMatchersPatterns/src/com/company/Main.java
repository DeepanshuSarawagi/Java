package com.company;

public class Main {

    public static void main(String[] args) {
        String alphaNumeric = "abcDeeeeFg111hhiiiiiJk910Xy";
        System.out.println(alphaNumeric.replaceAll("^abcDe{4}", "X"));
        // We use the quantifiers in the regEx. It is helpful to specify the exact count of preceding character which
        // match in the String.
        // A Quantifier specifies how often an element in a regular expression can occur

        // In the below example we will use the + quantifier which requires us not to specify the exact number of
        // occurrences of an element in the regular expression

        System.out.println(alphaNumeric.replaceAll("^abcDe+", "X"));

        // Supposedly if we dont want to specify the number of e's however, we want to ensure that it should be
        // followed by 0 or more e's then we need to use the asterisk quantifier

        System.out.println(alphaNumeric.replaceAll("abcDe*", "X"));

        // We can also the use the RegEx to validate if the String should have specific number of elements in the String

        System.out.println(alphaNumeric.replaceAll("^abcDe{2,5}", "X"));

        System.out.println(alphaNumeric.replaceAll("h+i*J", "Y"));
    }
}
