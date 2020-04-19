package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] myArray = new int[] {1, 2, 3, 4, 5};
        reverse(myArray);
    }

    private static void reverse(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[(array.length - 1) - i] ;
        }
        for (int i = 0; i < reversedArray.length; i++) {
            System.out.println("Element " + i + " after revering array is " + reversedArray[i]);
        }
    }
}
