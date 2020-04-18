package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AddOns addOns = new AddOns();
	    Hamburger hamburger = new Hamburger("Garlic Bread", "Chicken", addOns);
        System.out.println("Your basic hamburger is ready. It costs " + hamburger.getBasePrice());
        hamburger.addItems();

        System.out.println();

        HealthyHamburger healthyHamburger = new HealthyHamburger("Tuna Fish", addOns);
        System.out.println("Your basic hamburger is ready. It costs " + healthyHamburger.getBasePrice());
        healthyHamburger.addItems();

//        hamburger.AddAdditionalItems(2);
//        int count = 1;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please select the items to be added in the burger.");
//        while (count < 5) {
//            System.out.println("Please enter a number between 1-10 to add an additional item in burger: ");
//            boolean hasNextInt = scanner.hasNextInt();
//            if (hasNextInt) {
//                int number = scanner.nextInt();
//                hamburger.AddAdditionalItems(number);
//                count++;
//            } else {
//                System.out.println("Invalid input");
//            }
//            scanner.nextLine();
//        }
//        System.out.println("Your Hamburger is ready and final price is " + hamburger.HamBurgerFinalPrice());
    }
}
