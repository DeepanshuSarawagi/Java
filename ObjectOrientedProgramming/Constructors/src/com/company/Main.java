package com.company;

public class Main {

    public static void main(String[] args) {

        // Create objects of class Account
//        Account Deepanshu = new Account();
//
//        // Update the fields of object Deepanshu in class Account
//        Deepanshu.setAccountNumber(101);
//        Deepanshu.setCustomerName("Deepanshu Sarawagi");
//        Deepanshu.setEmail("deepanshu@email.com");
//        Deepanshu.setBalance(1000);
//        System.out.println("Balance is account " + Deepanshu.getCustomerName() + " is " + Deepanshu.getBalance());
//        Deepanshu.setPhoneNumber(89654);

        // Commented out above code so that we can create class objects using constructor

        Account Deepanshu = new Account(101, "Deepanshu Sarawagi", 100.0,
                "deepanshu@email.com", 868954);
        System.out.println(Deepanshu.getCustomerName());
        System.out.println(Deepanshu.getBalance());

        // Deposit amount
        Deepanshu.deposit(500);
        Deepanshu.withdraw(200);
    }
}
