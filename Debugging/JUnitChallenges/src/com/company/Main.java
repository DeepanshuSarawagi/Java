package com.company;

public class Main {

    public static void main(String[] args) {
        Utilities utilities = new Utilities();
        String result = utilities.removePairs("AABCDDEFF");
        System.out.println(result);

        System.out.println();
        char[] sourceArray = "hello world".toCharArray();
        char[] resultArray = utilities.everyNthChar(sourceArray, 2);
        System.out.println(resultArray);
    }
}
