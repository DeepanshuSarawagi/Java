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
        System.out.println(amount + "deposited. Updated balance in the account " + this.accountNumber +
                " is " + this.Balance);
    }

    public void withdraw(double amount) {
        this.Balance -= amount;
        System.out.println(amount + "withdrawn. Updated balance in the account " + this.accountNumber +
                " is " + this.Balance);
    }
}
