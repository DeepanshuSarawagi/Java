package com.company;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	    // Create a variable reference of Interface and assign to new object of class B
        A.NestedIf nestedIf = new B();
        System.out.println("Please enter an integer of your choice: ");
        int x = scanner.nextInt();
        scanner.nextLine();
        if (nestedIf.isNotNegative(x)) {
            System.out.println("Parameter passed in method is not negative");
        } else {
            System.out.println("Parameter passed is negative");
        }
    }
}
