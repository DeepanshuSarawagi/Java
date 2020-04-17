package com.company;

public class Hamburger {

    private String breadRollType;
    private double basePrice;
    private double AddOnsPrice = 0;
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

        public double HamBurgerFinalPrice() {
            return basePrice + AddOnsPrice;
        }
    }
