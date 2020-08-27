package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
	    Runnable runnable = () -> {
            String string = "Let's split this string into array";
            String[] strings = string.split(" ");
            Arrays.stream(strings)
                    .forEach(System.out::println);
        };
	    runnable.run();

        Function<String, String> lambdaString = s -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                if (i % 2 ==1) {
                    stringBuilder.append(s.charAt(i));
                    stringBuilder.append(" ");
                }
            }
            return stringBuilder.toString();
        };

        System.out.println(lambdaString.apply("1234567890"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string of your choice: ");
        String string = scanner.nextLine();

        everySecondCharacter(lambdaString, string);

    }

    public static void everySecondCharacter(Function<String, String> function, String str) {
        System.out.println(function.apply(str));
    }
}
