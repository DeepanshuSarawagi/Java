package com.company;

public class DeluxeBurger extends Hamburger{

    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 14.57, "White");
        super.addHamburgerAddition1("Chips", 2.5);
        super.addHamburgerAddition2("Coke", 5.0);
    }
}
