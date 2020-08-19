package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

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

        /*
        Now we are going to use Streams to achieve the same result as above in a single line of code
        A Stream is a sequence of elements supporting sequential and parallel operations.
        In the below examples, we have applied the Stream method to the source Collections object. And then we have
        asked the stream to convert all the objects in the collections to UpperCase, followed by a filter to filter the
        objects whose string starts with G and then calling the sorted() method to sort the items which are filtered and
        finally we print each element using the forEach() method.
        Note that, the original Collections someBingoNumbers is not manipulated. Every set of operation is independent.
        No changes will be made to the original list.
         */
        System.out.println();

        someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        // Building stream from the scratch

        Stream<String> ioInputStream = Stream.of("I17", "I29", "I26", "O71");
        Stream<String> inInputStream = Stream.of("N40", "N56", "I17", "I29", "I26", "O71");

        // We will concat two Streams together
        Stream<String> concatStream = Stream.concat(ioInputStream, inInputStream);

        // Print the number of items in the Stream
        System.out.println();
//        System.out.println("There are " + concatStream.count() + " items in the Stream");

        // Print the no. of distinct items in the Stream
        System.out.println("There are " + concatStream.distinct().count() + " distinct items in the Stream");
    }
}
