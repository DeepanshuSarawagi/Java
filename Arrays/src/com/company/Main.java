package com.company;

public class Main {

    public static void main(String[] args) {
	/* In this chapter we are going to learn about Arrays in Java.
	Array is nothing but a group of like-typed variables that are referred to by a common name. Arrays of any type can
	be created and have one or more dimension.
	 */
	    int[] month_days;  //  Initialize an array
        month_days = new int[12]; // define array size
        month_days[0] = 31;
        month_days[1] = 28;
        month_days[2] = 31;
        month_days[3] = 30;
        month_days[4] = 31;
        month_days[5] = 30;
        month_days[6] = 31;
        month_days[7] = 31;
        month_days[8] = 30;
        month_days[9] = 31;
        month_days[10] = 30;
        month_days[11] = 31;
        System.out.println("December month has " + month_days[11] + " days.");

        // Alternative way to define an array

        int[] Month_Days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.println("April has " + Month_Days[3] + " days");

        Average.average();
        MultiDimensionalArrays.twoDimensionalArray();
    }
}

class Average {

    public static void average() {

        double[] nums = {10.1, 11.2, 13.4, 14.5, 15.6};
        double result = 0;
        int i;
        for (i = 0; i < 5; i++) {
            result = result + nums[i];
        }
        System.out.println("Average is " + result);

    }

}