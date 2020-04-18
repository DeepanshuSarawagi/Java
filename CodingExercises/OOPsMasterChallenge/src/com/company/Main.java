package com.company;

public class Main {

    public static void main(String[] args) {
        AddOns addOns = new AddOns();
	    Hamburger hamburger = new Hamburger("Garlic Bread", "Chicken", addOns);
        System.out.println("Your basic hamburger of " + hamburger.getBreadRollType() +
                " and " + hamburger.getMeat() + " is ready");
        hamburger.wantAdditionalItems();

        System.out.println();

        HealthyHamburger healthyHamburger = new HealthyHamburger("Tuna Fish", addOns);
        System.out.println("Your basic healthy hamburger of " + healthyHamburger.getBreadRollType() + " with " +
                healthyHamburger.getMeat() + " is ready. ");
        healthyHamburger.wantAdditionalItems();

        System.out.println();

        DeluxeHamburger deluxeHamburger = new DeluxeHamburger("Parmesan Oregano",
                "Chicken", addOns, "Lays", "Coke");
        System.out.println("Your basic hamburger of " + deluxeHamburger.getBreadRollType() +
                " and " + deluxeHamburger.getMeat() + " with chips " + deluxeHamburger.getChips() + " drinks " +
                deluxeHamburger.getDrink() + " is ready");
        deluxeHamburger.addItems();

    }
}
