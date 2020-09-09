package com.company;

import static org.junit.jupiter.api.Assertions.*;

/**
 * assertNotEquals() - We can use this method when we dont want the actual value to be equal to the specific value.
 * assertArrayEquals() - When we want to verify the value of an array, we have to use the assertArrayEquals() method.
 *                      The assertEquals() method wont work since it will only check if two arrays are equal which is by
 *                      checking if they are the same instance of array. The assertArrayEquals() method consider two
 *                      arrays to be equal when their lengths are same and the values are same and in same order.
 * assertNull() and assertNotNull() - We can use this assert to check for the null and non-null values.
 * assertSame() -   We can use this to check if two instances are exact same instances. Remember that the assertEquals()
 *                  method use the equals() method to check for the equality, however, the assertSame() method uses the
 *                  method which compares the object references.
 * assertNotSame() - This is same as assertSame() method. Except that it checks if two instances are not exact same
 *                   object references.
 */

class BankAccountTest {

    @org.junit.jupiter.api.Test
    void deposit() {
        BankAccount account = new BankAccount("Deepanshu", "Sarawagi", 1000.00, BankAccount.CURRENT);
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
    void getBalance_deposit() {
        BankAccount account = new BankAccount("Deepanshu", "Sarawagi", 1000.00, BankAccount.CURRENT);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        BankAccount account = new BankAccount("Deepanshu", "Sarawagi", 1000.00, BankAccount.CURRENT);
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void isCurrent_true() {
        BankAccount account = new BankAccount("Deepanshu", "Sarawagi", 1000.00, BankAccount.CURRENT);
//        assertEquals(true, account.isCurrent());
        assertTrue(account.isCurrent(), "The account is NOT a CURRENT account");   // Simplify the assertion
    }

}