package com.company;

public class Main {

    public static void main(String[] args) {

        // Create objects of class Account
        Account Deepanshu = new Account();

        // Update the fields of object Deepanshu in class Account
        Deepanshu.setAccountNumber(101);
        Deepanshu.setCustomerName("Deepanshu Sarawagi");
        Deepanshu.setEmail("deepanshu@email.com");
        Deepanshu.setBalance(1000);
        System.out.println("Balance is account " + Deepanshu.getCustomerName() + " is " + Deepanshu.getBalance());
        Deepanshu.setPhoneNumber(89654);

        // Deposit amount
        Deepanshu.deposit(500);
        Deepanshu.withdraw(200);


    }
}
