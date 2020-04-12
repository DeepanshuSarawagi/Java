package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number;
        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;
//        boolean first = true;

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Enter number: ");
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                number = scanner.nextInt();

//                if (first) {
//                    first = false;
//                    minNumber = number;
//                    maxNumber = number;
//                }

                if (number > maxNumber) {
                    maxNumber = number;
                }
                if (number < minNumber) {
                    minNumber = number;
                }
            } else {
                System.out.println("Invalid Number");
                break;
            }
            scanner.nextLine();
        }
        System.out.println("Maximum number is: " + maxNumber);
        System.out.println("Minimum number is: " + minNumber);
        scanner.close();
    }
}
