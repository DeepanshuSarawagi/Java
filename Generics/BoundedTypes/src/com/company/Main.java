package com.company;

public class Main {

    public static void main(String[] args) {
	    Integer[] inums = {1, 2, 3, 4, 5, 6, 7};
	    Stats<Integer> stats = new Stats<>(inums);
        System.out.println("Average of nums is " + stats.average());
        System.out.println();
        Double[] dnums = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Stats<Double> stats1 = new Stats<>(dnums);
        System.out.println("Average of dnums is " + stats1.average());
    }
}
