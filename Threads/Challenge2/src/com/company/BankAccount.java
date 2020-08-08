package com.company;

public class BankAccount {
    private String AccountNumber;
    private double Balance;

    public BankAccount(String accountNumber, double balance) {
        AccountNumber = accountNumber;
        Balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.Balance += amount;
        } else {
            System.out.println("Amount cannot be less than zero.");
        }

        showBalance();
    }

}
