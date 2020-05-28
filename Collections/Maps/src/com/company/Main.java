package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        /**
         * Basics of Map Collection in Java
         */

        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "A compiled, high-level, object-oriented, platform independent language");
        languages.put("Python", "A interpreter high level, object-oriented language with dynamic semantics");
        languages.put("BASIC", "Beginners All purposes Symbolic Instruction Code");
        languages.put("Algol", "An algorithmic language");

//        System.out.println(languages.get("Java"));
//        languages.put("Java", "This course is about Java");
//        System.out.println(languages.get("Java"));  // This overwrites the value of key Java

        System.out.println(languages.put("Java", "This course is about Java")); // The put method helps us to find if
                                                                                // there is already a key-value pair
                                                                                // added in Map.

    }
}
