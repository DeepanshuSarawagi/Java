package com.series.deepanshu;

public class Series {
    protected static void nSum(int n) {
        int sum = 0;
        for (int i=0; i<=n; i++) {
            sum += i;
            System.out.print(sum + " ");
        }
    }
    protected static void factorial(int n) {
        long factN = 1;
        long factNMinus1;
        System.out.println("First " + n + " factorials are: ");
        if (n==0) {
            factN = 0;
            System.out.println("Factorial of " + n + " is " + factN);
        } else if (n==1) {
            System.out.println("Factorial of " + n + " is " + factN);
        } else {
            for (int i=2; i<=n; i++) {
                factNMinus1 = factN;
                factN = factNMinus1*i;
                System.out.println("Factorial of " + i + " is " + factN);
            }
        }
    }
}
