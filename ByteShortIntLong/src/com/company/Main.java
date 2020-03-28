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

		byte myMinByteValue = Byte.MIN_VALUE;
		byte myMaxByteValue = Byte.MAX_VALUE;

		System.out.println("Mininum Byte Value: " + myMinByteValue);
		System.out.println("Maximum Byte Value: " + myMaxByteValue);

		// Print the min and max short value in Java

		short myMinShortValue = Short.MIN_VALUE;
		short myMaxShortValue = Short.MAX_VALUE;

		System.out.println("Mininum Short Value: " + myMinShortValue);
		System.out.println("Maximum Short Value: " + myMaxShortValue);
    }
}
