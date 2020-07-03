package com.company;

public class Main {

    public static void main(String[] args) {
        int x = 98;
        int y = 0;  // this is deliberately done to raise error

        System.out.println(divideEAFP(x, y));
        System.out.println(divideLBYL(x, y));
        System.out.println(divide(x, y));       // To see the exceptions we get when dividing by zero
    }

    /*
    We are going to learn Exception Handling using two methods. One is Look Before You Leave (LBYL) and other one is
    Easy to Ask for Forgiveness and Permission.
     */
    private static int divideLBYL(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    private static int divide(int x, int y) {
        return x / y;
    }
}
