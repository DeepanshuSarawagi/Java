package com.company;

import java.util.Scanner;

public class Hamburger {

    private String breadRollType;
    private double basePrice;
    private double AddOnsPrice = 0;
    private double finalAddsOnPrice = 0;
    private String meat;
    private AddOns addOns;

    public Hamburger(String breadRollType, String meat, AddOns addOns) {
        this.breadRollType = breadRollType;
        this.basePrice = 15;
        this.meat = meat;
        this.addOns = addOns;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getMeat() {
        return meat;
    }

    public void wantAdditionalItems() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want additional Items to be added in your Burger? Type 'yes' or 'no'. ");
        String name = scanner.nextLine();
        if (name.toLowerCase().equals("yes")) {
            addItems();
        } else {
            System.out.println("Thank you for choosing basic hamburger! You burger costs " + getBasePrice());
        }
    }

    public void displayListOfAddOns() {
        System.out.println("The list of available add-ons are: " + "\n" +
                "1: " + addOns.getAddOn1() + "\n" +
                "2: " + addOns.getAddOn2() + "\n" +
                "3: " + addOns.getAddOn3() + "\n" +
                "4: " + addOns.getAddOn4() + "\n" +
                "5: " + addOns.getAddOn5() + "\n" +
                "6: " + addOns.getAddOn6() + "\n" +
                "7: " + addOns.getAddOn7() + "\n" +
                "8: " + addOns.getAddOn8() + "\n" +
                "9: " + addOns.getAddOn9() + "\n" +
                "10: " + addOns.getAddOn10() + "\n");
    }

    public void AddAdditionalItems(int item) {
        switch (item) {
            case 1:
                String addItem1 = addOns.getAddOn1();
                System.out.println("Additional item " + addItem1 + " has been added with price of " +
                        addOns.getAddOn1Value());
                AddOnsPrice += addOns.getAddOn1Value();
                break;
            case 2:
                String addItem2 = addOns.getAddOn2();
                System.out.println("Additional item " + addItem2 + " has been added with price of " +
                        addOns.getAddOn2Value());
                AddOnsPrice += addOns.getAddOn2Value();
                break;
            case 3:
                String addItem3 = addOns.getAddOn3();
                System.out.println("Additional item " + addItem3 + " has been added with price of " +
                        addOns.getAddOn3Value());
                AddOnsPrice += addOns.getAddOn3Value();
                break;
            case 4:
                String addItem4 = addOns.getAddOn4();
                System.out.println("Additional item " + addItem4 + " has been added with price of " +
                        addOns.getAddOn4Value());
                AddOnsPrice += addOns.getAddOn4Value();
                break;
            case 5:
                String addItem5 = addOns.getAddOn5();
                System.out.println("Additional item " + addItem5 + " has been added with price of " +
                        addOns.getAddOn5Value());
                AddOnsPrice += addOns.getAddOn5Value();
                break;
            case 6:
                String addItem6 = addOns.getAddOn6();
                System.out.println("Additional item " + addItem6 + " has been added with price of " +
                        addOns.getAddOn6Value());
                AddOnsPrice += addOns.getAddOn6Value();
                break;
            case 7:
                String addItem7 = addOns.getAddOn7();
                System.out.println("Additional item " + addItem7 + " has been added with price of " +
                        addOns.getAddOn7Value());
                AddOnsPrice += addOns.getAddOn7Value();
                break;
            case 8:
                String addItem8 = addOns.getAddOn8();
                System.out.println("Additional item " + addItem8 + " has been added with price of " +
                        addOns.getAddOn8Value());
                AddOnsPrice += addOns.getAddOn8Value();
                break;
            case 9:
                String addItem9 = addOns.getAddOn9();
                System.out.println("Additional item " + addItem9 + " has been added with price of " +
                        addOns.getAddOn9Value());
                AddOnsPrice += addOns.getAddOn9Value();
                break;
            case 10:
                String addItem10 = addOns.getAddOn10();
                System.out.println("Additional item " + addItem10 + " has been added with price of " +
                        addOns.getAddOn10Value());
                AddOnsPrice += addOns.getAddOn10Value();
                break;
            
            default:
                break;
            }
        }

        public double FinalPrice() {
            finalAddsOnPrice += this.AddOnsPrice;
            return finalAddsOnPrice;
        }
        public double HamBurgerFinalPrice() {
            return basePrice + FinalPrice();
        }

        public void addItems() {
            int count = 1;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select the items to be added in the burger from the below list");
            displayListOfAddOns();
            while (count < 5) {
                System.out.println("Please enter a number between 1-10 to add an additional item in burger: ");
                boolean hasNextInt = scanner.hasNextInt();
                if (hasNextInt) {
                    int number = scanner.nextInt();
                    AddAdditionalItems(number);
                    count++;
                } else {
                    System.out.println("Invalid input");
                }
                scanner.nextLine();
            }
            System.out.println("Your Hamburger is ready and final price is " + HamBurgerFinalPrice());
        }
    }

    class HealthyHamburger extends Hamburger {
        private double BasePrice;
        public HealthyHamburger(String meat, AddOns addOns) {
            super("Brown rye Bread Roll", meat, addOns);
            this.BasePrice = 18.0;
        }

        @Override
        public double getBasePrice() {
            return this.BasePrice;
        }

        @Override
        public double HamBurgerFinalPrice() {
            return this.BasePrice + FinalPrice();
        }

        @Override
        public void addItems() {
            int count = 1;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Thank you for selecting Healthy Hamburger. " +
                    "Please select upto 6 items to be added in the burger from the below list.");
            displayListOfAddOns();
            while (count < 7) {
                System.out.println("Please enter a number between 1-10 to add an additional item in burger: ");
                boolean hasNextInt = scanner.hasNextInt();
                if (hasNextInt) {
                    int number = scanner.nextInt();
                    AddAdditionalItems(number);
                    count++;
                } else {
                    System.out.println("Invalid input");
                }
                scanner.nextLine();
            }
            System.out.println("Your Healthy Hamburger is ready and final price is " + HamBurgerFinalPrice());
        }
    }

    class DeluxeHamburger extends Hamburger {
        private String Chips;
        private String Drink;
        private double BasePrice;

        public DeluxeHamburger(String breadRollType, String meat, AddOns addOns, String Chips, String Drink) {
            super(breadRollType, meat, addOns);
            this.BasePrice = 20.0;
            this.Chips = Chips;
            this.Drink= Drink;
        }

        public String getChips() {
            return Chips;
        }

        public String getDrink() {
            return Drink;
        }

        @Override
        public double getBasePrice() {
            return this.BasePrice;
        }

        @Override
        public void addItems() {
            System.out.println("Sorry! No additional items can be added to Deluxe Hamburger! You " +
                    "Deluxe Hamburger costs " + getBasePrice());
        }
    }
