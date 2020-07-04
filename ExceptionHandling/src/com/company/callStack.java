package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class callStack {
    public static void main(String[] args) {
        int x = getInt();
        int y = getInt();

        System.out.println(divide(x, y));

        x = getIntEAFP();
        y = getIntEAFP();

        System.out.println(divide(x, y));
    }

    private static int getInt() {
        System.out.println("Please enter an integer of your choice: ");
        Scanner scanner = new Scanner(System.in);
        boolean hasNextInt = scanner.hasNextInt();
        while (!hasNextInt) {
            System.out.println("That was an invalid input. Please re-enter integer of your choice: ");
            scanner.nextLine();
            hasNextInt = scanner.hasNextInt();
        }
        return scanner.nextInt();
    }

    private static int getIntEAFP() {
        System.out.println("Please enter an integer of your choice: ");
        Scanner scanner = new Scanner(System.in) ;

        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("That was an invalid input. Please try again: ");
            }
        }
    }

    private static int divide(int x, int y) {
        return x / y;
    }
}
