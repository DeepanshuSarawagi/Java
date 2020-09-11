package com.company;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        fail("This test has not been implemented");
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
        Utilities utilities = new Utilities();
        String result = utilities.removePairs("AABCDDEFF");
        System.out.println(result);
        assertEquals("ABCDEF", result);
        result = utilities.removePairs("ABCCDBEEF");
        System.out.println(result);
        assertEquals("ABCDBEF", result);
        assertNull(null, utilities.removePairs(null));
    }

    @org.junit.jupiter.api.Test
    void converter() {
        fail("This test has not been implemented");
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        fail("This test has not been implemented");
    }
}