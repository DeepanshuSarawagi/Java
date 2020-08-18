package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList("N40", "N36",
                "G53", "G71", "G11", "g64",
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

        // Create a new ArrayList
        List<String> gNumbers = new ArrayList<>();

        someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });
        System.out.println();

        gNumbers.sort((String o1, String o2) -> o1.compareTo(o2));
        gNumbers.forEach(s -> System.out.println(s));

    }
}
