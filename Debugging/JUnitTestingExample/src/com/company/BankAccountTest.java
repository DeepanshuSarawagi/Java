package com.company;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @org.junit.jupiter.api.Test
    void deposit() {
        BankAccount account = new BankAccount("Deepanshu", "Sarawagi", 1000.00);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);  // The third parameter in the assertEquals() method is the
        // delta value. This means that it allows some leeway in the comparison. So as long as the difference between
        // the actual and expected value is within the delta value range, the test assertion result will pass. In our
        // case we expect the value to be 1200.00 hence we have specified the delta to be 0
        assertEquals(1200, account.getBalance(), 0);

        // One important point to note here is that all the Test method should be self-contained. In other words, what
        // happens in one Test method should be independent of what happens in the rest of the Test methods. All the
        // Test method results should be independent of each other
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        fail("This test is yet to be implemented");
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        BankAccount account = new BankAccount("Deepanshu", "Sarawagi", 1000);
        account.deposit(200, true);
        assertEquals(1200, account.getBalance(), 0);
    }

}