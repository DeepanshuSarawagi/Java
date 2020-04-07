package com.company;

/* Create a for statement using a range of numbers from 1 to 1000 inclusive.

Sum all the numbers that can be divided with both 3 and also with 5.

For those numbers that met the above conditions, print out the number.

break out of the loop once you find 5 numbers that met the above conditions.

After breaking out of the loop print the sum of the numbers that met the above conditions.

Note: Type all code in main method

 */

public class Main {

//    int sumOf3And5 = 0;
    public static void main(String[] args) {
	    for (int i = 0; i <= 1000; i+=15){
            System.out.println("Numbers divisible by both 3 and 5 is: " + i);
        }
    }
}
