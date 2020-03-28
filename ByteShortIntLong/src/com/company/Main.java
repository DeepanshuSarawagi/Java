package com.company;

public class Main {

    public static void main(String[] args) {

		int myValue = 10000;
		int myMinIntValue = Integer.MIN_VALUE;
		int myMaxIntValue = Integer.MAX_VALUE;

		System.out.println("Minimum Integer value: " + myMinIntValue);
		System.out.println("Maximum Integer value: " + myMaxIntValue);

		System.out.println("Busted Max Integer value: " + (myMaxIntValue + 1));
		// As you can see the maximum Integer value is busted since the computer has already
		// allocated the maximum integer value it can accept and we busted it by adding 1 to it
    }
}
