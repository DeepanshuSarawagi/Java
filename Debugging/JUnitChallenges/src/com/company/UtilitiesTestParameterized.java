package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTestParameterized {

    private Utilities utilities;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        utilities = new Utilities();
    }


    @DisplayName("Parametrized test of removePairs")
    @ParameterizedTest
    @MethodSource("sourceValues")
    void removePairs(String source, String expected) {
        assertEquals(expected, utilities.removePairs(source));
    }

    @org.junit.jupiter.api.Test
    private static Stream<Arguments> sourceValues() {
        return Stream.of(Arguments.of("ABCDEFF", "ABCDEF"),
                        Arguments.of("AB88EFFG", "AB8EFG"),
                        Arguments.of("112233445566", "123456"),
                        Arguments.of("ZYZQQB", "ZYZQB"),
                        Arguments.of("A", "A"));
    }

}
