package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList("N40", "N36",
                "G53", "G71", "G11",
                "I26", "I70",
                "B5", "B29", "B16");

        for (String string : someBingoNumbers) {
            if (string.contains("G")) {
                System.out.println(string);
            }
        }

        // We can do the same thing using forEach and Lambda Expression
        System.out.println();
        someBingoNumbers.forEach(number -> {
            if (number.startsWith("G")) {
                System.out.print(number + "\t");
            }
        });
    }
}
