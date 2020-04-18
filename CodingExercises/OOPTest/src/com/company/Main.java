package com.company;

public class Main {

    public static void main(String[] args) {
	    Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White Roll");
	    double price = hamburger.itemizedHamburger();
        System.out.println(price);
        hamburger.addHamburgerAddition1("Tomota", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.25);
        hamburger.addHamburgerAddition3("Cheese", 1.0);
        System.out.println("Total Burger price is " + hamburger.itemizedHamburger());

        System.out.println();

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
        healthyBurger.addHamburgerAddition1("Eggs", 1.56);
        healthyBurger.addHealthAddition1("Lentils", 5.0);
        System.out.println("Total Healthy burger price is " + healthyBurger.itemizedHamburger());

        System.out.println();

        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.addHamburgerAddition3("Carrot", 2.5);
        deluxeBurger.itemizedHamburger();

    }

}
