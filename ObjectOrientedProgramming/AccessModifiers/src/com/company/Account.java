package com.company;

import java.util.ArrayList;

public class Account {
    private String AccountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        AccountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return this.balance;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " deposited. Balance is now " + this.balance);
        } else {
            System.out.println("Cannot deposit negative sums.");
        }
    }

    public void withdrawal(int amount) {
        int withdrawal = -amount;
        if (withdrawal < 0) {
            this.transactions.add(withdrawal);
            this.balance += withdrawal;
            System.out.println(amount + " withdrawn. Balance is now " + this.balance);
        } else {
            System.out.println("Cannot withdraw negative amount.");
        }
    }

    public void calculateBalance() {
        this.balance = 0;
        for (int i: this.transactions) {
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance);
    }
    public void showTransactions() {
        for (int i: this.transactions) {
            if (i > 0) {
                System.out.println(i + " deposited.");
            } else {
                System.out.println(i + " withdrawn.");
            }
        }
    }
}
