package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount{
    private double Balance;
    private String accountNumber;
    private ReentrantLock lock;

    public BankAccount(double balance, String accountNumber) {
        Balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
//            lock.lock();
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    this.Balance += amount;
                    System.out.println(amount + "deposited. Updated balance in the account " + this.accountNumber +
                            " is " + this.Balance);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Couldn't acquire lock on the object");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void withdraw(double amount) {
//            lock.lock();
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    this.Balance -= amount;
                    System.out.println(amount + "withdrawn. Updated balance in the account " + this.accountNumber +
                            " is " + this.Balance);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Couldn't get lock on the object");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void PrintAccountNumber() {
        System.out.println("Account Number = " + this.accountNumber);
    }
}
