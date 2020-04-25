package com.company;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("ICICI");
        bank.addBranch("Chennai");
        bank.addCustomer("Chennai", "Deepanshu", 145.2);
        bank.addCustomer("Chennai", "Divya", 345.12);
        bank.addCustomer("Chennai", "Rajat", 324.34);
        bank.addBranch("Pune");
        bank.addCustomer("Pune", "Raj", 1234.543);
        bank.addCustomerTransaction("Chennai", "Deepanshu", 123.3);
        bank.addCustomerTransaction("Chennai", "Divya", 32.45);
        bank.addCustomerTransaction("Pune", "Raj", 231.34);
        bank.listCustomers("Chennai", false);
        bank.listCustomers("Chennai", true);


    }
}
