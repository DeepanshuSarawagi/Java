package com.company;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("345-19801", 1000);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(200);
            }
        });

        t1.start();
    }
}
