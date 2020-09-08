package com.company;

public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;
    public static final int CURRENT = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }

    // The branch argument is true if the customer is performing the transaction
    // at the branch. It is false if the customer is performing transaction
    // at the ATM.

    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch) {
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean isCurrent() {
        return this.accountType == CURRENT;
    }
}
