package com.company;

public class Account {

    private int AccountNumber;
    private String customerName;
    private int Balance = 0;
    private String email;
    private int phoneNumber;

    // Create setters for Account fields

    public void setAccountNumber (int AccountNumber)  {
        this.AccountNumber = AccountNumber;
    }

    public void setCustomerName (String customerName) {
        this.customerName = customerName;
    }

    public void setBalance (int balance) {
        this.Balance = balance;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setPhoneNumber (int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Create getters for retrieving Account field`s data

    public int getAccountNumber() {
        return this.AccountNumber;
    }

    public int getBalance() {
        return this.Balance;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getCustomerName () {
        return this.customerName;
    }

    public String getEmail() {
        return this.email;
    }

    // Create a public method to deposit amount

    public void deposit (int amount) {
        this.Balance += amount;
    }

    // Create a public method to withdraw amount

    public void withdraw (int amount) {
        if (this.Balance < 0) {
            System.out.println("Your account has insufficient funds to withdraw.");
        } else {
            this.Balance -= amount;
        }
    }
}
