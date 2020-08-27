package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Runnable runnable = () -> {
            String string = "Let's split this string into array";
            String[] strings = string.split(" ");
            Arrays.stream(strings)
                    .forEach(System.out::println);
        };
	    runnable.run();
    }
}
