package com.series.deepanshu;

public class Series {
    protected static void nSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
            System.out.print(sum + " ");
        }
    }

    protected static void factorial(int n) {
        long factN = 1;
        long factNMinus1;
        System.out.println("First " + n + " factorials are: ");
        if (n == 0) {
            factN = 0;
            System.out.println("Factorial of " + n + " is " + factN);
        } else if (n == 1) {
            System.out.println("Factorial of " + n + " is " + factN);
        } else {
            for (int i = 2; i <= n; i++) {
                factNMinus1 = factN;
                factN = factNMinus1 * i;
                System.out.println("Factorial of " + i + " is " + factN);
            }
        }
    }

    protected static void fibonacci(int n) {
        long fibN = 0;
        long fibNMinus1 = 1;
        long fibNMinus2 = 0;
        if (n == 0) {
            System.out.println("Fibonacci of " + n + " is " + fibN);
        } else if (n == 1) {
            fibN = 1;
            System.out.println("Fibonacci of " + n + " is " + fibN);
        } else {
            for (int i = 0; i <= n; i++) {
                if (i == 0) {
                    fibN = 0;
                    System.out.println("Fibonacci of " + i + " is " + fibN);
                } else if (i == 1) {
                    fibN = 1;
                    System.out.println("Fibonacci of " + i + " is " + fibN);
                } else {
                    fibN = fibNMinus2 + fibNMinus1;
                    System.out.println("Fibonacci of " + i + " is " + fibN);
                    fibNMinus2 = fibNMinus1;
                    fibNMinus1 = fibN;
                }
            }
        }
    }
}