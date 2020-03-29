package com.company;

import javax.print.DocFlavor;

public class Main {

    public static void main(String[] args) {

		int myMinIntValue = Integer.MIN_VALUE;
		int myMaxIntValue = Integer.MAX_VALUE;

		System.out.println("Minimum Integer value: " + myMinIntValue);
		System.out.println("Maximum Integer value: " + myMaxIntValue);

		System.out.println("Busted Max Integer value: " + (myMaxIntValue + 1));
		// As you can see the maximum Integer value is busted since the computer has already
		// allocated the maximum integer value it can accept and we busted it by adding 1 to it
		System.out.println();
		byte myMinByteValue = Byte.MIN_VALUE;
		byte myMaxByteValue = Byte.MAX_VALUE;

		System.out.println("Mininum Byte Value: " + myMinByteValue);
		System.out.println("Maximum Byte Value: " + myMaxByteValue);
		System.out.println();
		// Print the min and max short value in Java

		short myMinShortValue = Short.MIN_VALUE;
		short myMaxShortValue = Short.MAX_VALUE;

		System.out.println("Mininum Short Value: " + myMinShortValue);
		System.out.println("Maximum Short Value: " + myMaxShortValue);
		System.out.println();
		// print the maximum and minimum long value in Java
		long myMinLongValue = Long.MIN_VALUE;
		long myMaxLongValue = Long.MAX_VALUE;

		System.out.println("Mininum Long Value: " + myMinLongValue);
		System.out.println("Maximum Long Value: " + myMaxLongValue);
		System.out.println();

		long bigLongLiteralValue = 2_147_483_647134L;  // you need to specify an L in the end if it is a Long data type
		System.out.println(bigLongLiteralValue);
		System.out.println();

		int myTotalValue = (myMinIntValue / 2);
		System.out.println(myTotalValue);
		System.out.println();

//		byte myNewByteValue = (myMinByteValue / 2); // This will error since we need to tell Java it is a byte data type
		// we do that by a concept called casting. Just add the data type in parenthesis in front of value to convert
		// from one data type to another
		byte myNewByteValue = (byte)(myMinByteValue / 2);
		System.out.println(myNewByteValue);
//		String divya = "divya";
//		int i=1;
//		for(i=1;i<8;i++)
//		{
//			System.out.println("hi my name is " + divya);
//			System.out.println("say " + i);
//		}
//		System.out.println("THE LENGHT OF MY NAME " + divya.length());

    }
}
