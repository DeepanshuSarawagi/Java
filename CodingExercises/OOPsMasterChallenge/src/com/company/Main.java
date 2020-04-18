package com.company;

public class Main {

    public static void main(String[] args) {
        AddOns addOns = new AddOns();
	    Hamburger hamburger = new Hamburger("Garlic Bread", "Chicken", addOns);
        System.out.println("Your basic hamburger is ready. It costs " + hamburger.getBasePrice());
        hamburger.addItems();

        System.out.println();

        HealthyHamburger healthyHamburger = new HealthyHamburger("Tuna Fish", addOns);
        System.out.println("Your basic healthy hamburger of" + healthyHamburger.getBreadRollType() + " with " +
                healthyHamburger.getMeat() + " is ready. " +
                "It costs " + healthyHamburger.getBasePrice());
        healthyHamburger.addItems();

    }
}
