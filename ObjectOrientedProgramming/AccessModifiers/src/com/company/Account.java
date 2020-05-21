package com.company;

import java.util.ArrayList;

public class Account {
    private String AccountName;
    private int balance = 0;
    public ArrayList<Integer> transactions;

    public Account(String accountName) {
        AccountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return this.balance;
    }

}
