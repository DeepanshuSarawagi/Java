package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        /**
         * In this lesson we are going to learn about symmetric and asymmetric sets.
         */

        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i=1; i<=100; i++) {
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println("The no. of elements in squares set it " + squares.size() + " and no. of elements in cubes " +
                "set is " + cubes.size());

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);

        System.out.println("There are " + union.size() + " elements in union set and " + intersection.size() + " in" +
                " intersection set.");

        for (Integer integer : intersection) {
            System.out.println(integer + " is square of " + Math.sqrt(integer) + " and cube of " + Math.cbrt(integer));
        }
    }
}
