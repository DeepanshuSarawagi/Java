package com.company;

public class DeluxeBurger extends Hamburger{

    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 14.57, "White");
        super.addHamburgerAddition1("Chips", 2.5);
        super.addHamburgerAddition2("Coke", 5.0);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Cannot add additional items to deluxe hamburger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Cannot add additional items to deluxe hamburger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Cannot add additional items to deluxe hamburger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Cannot add additional items to deluxe hamburger");
    }
}
