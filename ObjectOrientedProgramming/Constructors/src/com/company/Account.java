package com.company;

public class Account {

    private int AccountNumber;
    private String customerName;
    private double Balance = 0;
    private String email;
    private int phoneNumber;

    // creating an empty constructor
    public Account() {
        // calling a constructor within a constructor. If an empty constructor is called then below default values
        // will be created using this() statement. this() has to be the first statement in the empty constructor body

        this(100, "Default Name", 5.0, "default@email.com",
                900800);
        System.out.println("Empty constructor called");
    }

    // create one more constructor with just three parameters and rest set to default
    public Account(String customerName, String email, int phoneNumber) {
        this(9999, customerName, 10.5, email, phoneNumber );
    }

    // Create a constructor with parameters
    public Account(int AccountNumber, String customerName, double Balance, String email, int phoneNumber) {
        System.out.println("Account constructor called with parameters");
        this.AccountNumber = AccountNumber;
        this.customerName = customerName;
        this.Balance = Balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Create setters for Account fields

    public void setAccountNumber (int AccountNumber)  {
        this.AccountNumber = AccountNumber;
    }

    public void setCustomerName (String customerName) {
        this.customerName = customerName;
    }

    public void setBalance (double Balance) {
        this.Balance = Balance;
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

    public double getBalance() {
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

    public void deposit (double amount) {
        this.Balance += amount;
        System.out.println("Amount " + amount + " deposited in the account of " + this.customerName);
    }

    // Create a public method to withdraw amount

    public void withdraw (double amount) {
        if (this.Balance - amount < 0) {
            System.out.println("Your account has insufficient funds to withdraw.");
        } else {
            this.Balance -= amount;
            System.out.println("Amount " + amount + " withdrawn from the account of " + this.customerName
                    +". Remaining balance is " + this.Balance );
        }
    }
}
