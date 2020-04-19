package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myArray = readIntegers(5);
        for (int i = 0; i < myArray.length; i++) {
            System.out.println("Element #" + i + " entered was " + myArray[i]);
        }
        System.out.println("Minimum element in array is " + findMin(myArray));

        scanner.close();
    }

    public static int[] readIntegers(int count) {
        int [] array = new int[count];
        System.out.println("Enter valid integers of your choice");

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

//    public static int findMin(int[] array) {
//        boolean flag = true;
//        while (flag) {
//            flag = false;
//            for (int i = 0; i < array.length - 1; i++) {
//                if (array[i] > array[i + 1]) {
//                    array[i] = array[i+1];
//                    array[i + 1] = array[i];
//                    flag = true;
//                }
//            }
//        }
//        return array[0];
//    }

    // alternative solution by me

    public static int findMin(int[] array) {
        int minimum = Integer.MAX_VALUE;
        for (int value : array) {
            if (value < minimum) {
                minimum = value;
            }
        }
        return minimum;
    }
}
