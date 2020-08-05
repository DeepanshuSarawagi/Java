package com.company;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000, "12536-564");

        new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(300);
                bankAccount.withdraw(50);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(203.75);
                bankAccount.withdraw(100);
            }
        }).start();
    }
}
