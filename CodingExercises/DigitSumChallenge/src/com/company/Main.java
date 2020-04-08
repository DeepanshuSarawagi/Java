package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumDigits(99999));
    }

    public static int sumDigits(int n) {
        int lastDigit;
        int remainingDigits;
        int sumOfDigits = 0;
        if (n <= 9) {
            return -1;
        } else {
            remainingDigits = n / 10;
            lastDigit = n % 10;
            sumOfDigits = sumOfDigits + lastDigit;
            while (true) {
                if ((remainingDigits != 0)) {
                    lastDigit = remainingDigits % 10;
                    remainingDigits = remainingDigits / 10;
                    sumOfDigits = sumOfDigits + lastDigit;
                }
                else {
                    break;
                }
            }
        }
        return sumOfDigits;
    }
}
