package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumDigits(87346923));
    }

    public static int sumDigits(int n) {
        int lastDigit;
        int remainingDigits;
        int sumOfDigits = 0;
        if (n <= 9) {
            return -1;
        } else {
            remainingDigits = n / 10;
            System.out.println("Remaining digits are now: " + remainingDigits);  // TODO remove this line after testing
            lastDigit = n % 10;
            System.out.println("Last digit is: " + lastDigit); // TODO remove this line after testing
            sumOfDigits = sumOfDigits + lastDigit;
            System.out.println("Sum of digits is now: " + sumOfDigits); // TODO remove this line after testing
            while (true) {
                if ((remainingDigits != 0)) {
                    lastDigit = remainingDigits % 10;
                    remainingDigits = remainingDigits / 10;
                    System.out.println("Last digit is now: " + lastDigit);  // TODO remove this line after testing
                    System.out.println("remaining digits are now: " + remainingDigits); // TODO remove this line after testing
                    sumOfDigits = sumOfDigits + lastDigit;
                    System.out.println("Sum of digits is now: " + sumOfDigits); // TODO remove this line after testing
                }
                else {
                    break;
                }
            }
        }
        return sumOfDigits;
    }
}
