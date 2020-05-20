package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number of your choice: ");
        X x = new X(scanner.nextInt());
        x.x();
    }
}
