package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x = 98;
        int y = 2;  // this is deliberately done to raise error

        System.out.println(divideEAFP(x, y));
        System.out.println(divideLBYL(x, y));
        System.out.println(divide(x, y));       // To see the exceptions we get when dividing by zero
        x = getInt();
        System.out.println("x is " + x);

        x = getIntLBYL();
        System.out.println("x is " + x);

        x = getIntEAFP();
        System.out.println("x is " + x);
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

    private static int getInt() {
        System.out.println("Please enter a number of your choice: ");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer: ");
        String input = s.next();

        for (int i =0; i<input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer: ");

        try {
            return s.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }
}
