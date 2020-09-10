package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTestParameterized {

    private BankAccount account;

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        account = new BankAccount("Deepanshu", "Sarawagi", 1000.00, BankAccount.CURRENT);
        System.out.println("Running a test..");
    }

    @DisplayName("Test with @MethodSource")
    @ParameterizedTest
    @MethodSource("parameterValues")
    void getBalance_deposit(double amount, boolean b, double expected) {
        account.deposit(amount, b);
        assertEquals(expected, account.getBalance(), 0.01);
    }

    private static Stream<Arguments> parameterValues() {
        return Stream.of(Arguments.of(200.00, true, 1200.00),
                        Arguments.of(300.00, true, 1300.00),
                        Arguments.of(124.14, true, 1124.14),
                        Arguments.of(489.33, true, 1489.33),
                        Arguments.of(325.14, true, 1325.14));
    }
}
