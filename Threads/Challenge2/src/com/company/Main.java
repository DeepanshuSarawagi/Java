package com.company;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("345-19801", 1000);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (bankAccount) {
                    bankAccount.deposit(200);
                    bankAccount.withdraw(100);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (bankAccount) {
                    bankAccount.deposit(150);
                    bankAccount.deposit(50);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
