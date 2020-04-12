package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number1;
        int number2;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter first number: ");
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                number1 = scanner.nextInt();
                System.out.println("Entered Number is: " + number1);
            } else {
                System.out.println("Invalid Number");
                break;
            }
            System.out.println("Enter second number: ");
            hasNextInt = scanner.hasNextInt();
            if(hasNextInt) {
                number2 = scanner.nextInt();
                System.out.println("Entered number is: " + number2);
            } else {
                break;
            }
            int maxNumber = Math.max(number1, number2);
            int minNumber = Math.min(number1, number2);
            System.out.println("Maximum number is: " + maxNumber);
            System.out.println("Minimum number is: " + minNumber);
        }
        scanner.nextLine();
        scanner.close();
    }
}
