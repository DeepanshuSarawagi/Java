package com.company;

public class Main {

    public static void main(String[] args) {
        AddOns addOns = new AddOns();
	 Hamburger hamburger = new Hamburger("Garlic Bread", "Chicken", addOns);
        System.out.println(hamburger.getBasePrice());
//        hamburger.AddAdditionalItems(2);
        int count = 1;
        System.out.println("Please select the items to be added in the burger.");
        while (count < 5) {
            hamburger.AddAdditionalItems(count);
            count++;
        }
        System.out.println("Your Hamburger is ready and final price is " + hamburger.HamBurgerFinalPrice());
    }
}
