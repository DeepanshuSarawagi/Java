package com.company;


public class Main {

    public static void main(String[] args) {

        int result = 1 + 2;
        System.out.println("1 + 2 = " + result);
        int previousResult = result;
        System.out.println("Previous result is = " + previousResult);
        result -= 1;
        System.out.println("Result's new value is: " + result);
        result *= 10;
        System.out.println("Result is now: " + result);

        double resultDouble = (result / 3d);
        System.out.println("Result is now: " + resultDouble);

    }
}
