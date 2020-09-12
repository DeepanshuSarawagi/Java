package com.company;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        Utilities utilities = new Utilities();
        char[] sourceArray = "hello world".toCharArray();
        char[] output = utilities.everyNthChar(sourceArray, 2);
        assertArrayEquals(new char[] {'e', 'l', ' ', 'o', 'l'}, output);
        sourceArray = "hello".toCharArray();
        output = utilities.everyNthChar(sourceArray, 6);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output);

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
        Utilities utilities = new Utilities();
        assertEquals(300, utilities.converter(10, 5));
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        Utilities utilities = new Utilities();

        assertEquals(null, utilities.nullIfOddLength("hello"));
    }
}