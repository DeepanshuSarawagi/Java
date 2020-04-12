package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        int number;
        Scanner scanner = new Scanner(System.in);
        while (count < 10) {
            int order = count + 1;
            System.out.println("Enter # " + order + ":" );
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                number = scanner.nextInt();
                count++;
                sum += number;
            } else {
                System.out.println("Invalid number");
            }
            scanner.nextLine();
        }
        System.out.println("Sum of 10 entered number is: " + sum);
        scanner.close();
    }
}
