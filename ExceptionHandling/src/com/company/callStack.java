package com.company;

import java.util.Scanner;

public class callStack {
    public static void main(String[] args) {
        int x = getInt();
        int y = getInt();

        System.out.println(divide(x, y));
    }

    private static int getInt() {
        System.out.println("Please enter an integer of your choice: ");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            System.out.println("That was an invalid input. Please re-enter integer of your choice: ");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    private static int divide(int x, int y) {
        return x / y;
    }
}
