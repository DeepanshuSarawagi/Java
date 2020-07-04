package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class callStack {
    public static void main(String[] args) {
        try {

            int x = getInt();
            int y = getInt();

            System.out.println(divide(x, y));

            x = getIntEAFP();
            y = getIntEAFP();

            System.out.println(divide(x, y));
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("No input found from user");
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
            System.out.println("Not able to perform division");
        }
    }

    private static int getInt() {
        System.out.println("Please enter an integer of your choice: ");
        Scanner scanner = new Scanner(System.in);
        boolean hasNextInt = scanner.hasNextInt();
        try {
            while (!hasNextInt) {
                System.out.println("That was an invalid input. Please re-enter integer of your choice: ");
                scanner.nextLine();
                hasNextInt = scanner.hasNextInt();
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No suitable input");
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
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException("No suitable input");
            }
        }
    }

    private static int divide(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Attempted division by zero");
        }

    }
}
