package com.company;

public class Main {

    public static void main(String[] args) {
        Account deepsAccount = new Account("Deepanshu");
        deepsAccount.deposit(1000);
        deepsAccount.withdrawal(500);
        deepsAccount.withdrawal(-100);
        deepsAccount.deposit(-1000);
        deepsAccount.showTransactions();
        deepsAccount.calculateBalance();

        System.out.println("Balance in account " + deepsAccount.getAccountName() + " is " + deepsAccount.getBalance());
    }
}
