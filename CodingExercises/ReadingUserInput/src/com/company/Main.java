package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 1;
        int sum = 0;
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number of your choice: ");
        boolean hasNextInt = scanner.hasNextInt();
        if (hasNextInt) {
            while (count < 11) {
                number = scanner.nextInt();
                System.out.println("Entered #" + count + " is: " + number);
                sum += number;
                count++;
                System.out.println("Please enter a number of your choice: ");
                scanner.hasNextInt();
            }
        }
        else {
            System.out.println("Please enter a valid number: ");
            scanner.nextLine();
            while (count < 11) {
                number = scanner.nextInt();
                System.out.println("Entered #" + count + " is: " + number);
                sum += number;
                count++;
                System.out.println("Please enter a number of your choice: ");
                scanner.hasNextInt();
            }
        }
        System.out.println("Sum of 10 entered number is: " + sum);
    }
}
