package com.company;

public class BankAccount {
    private double Balance;
    private String accountNumber;

    public BankAccount(double balance, String accountNumber) {
        Balance = balance;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        this.Balance += amount;
    }

    public void withdraw(double amount) {
        this.Balance -= amount;
    }
}
