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
        languages.put("Lisp", "Therein goes madness");
        languages.put("Javascript", "A powerful front end language");

//        System.out.println(languages.get("Java"));
        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the Map");
        } else {
            languages.put("Java", "This course is about Java");
        }
//        System.out.println(languages.get("Java"));  // This overwrites the value of key Java

//        System.out.println(languages.put("Java", "This course is about Java")); // The put method helps us to find if
                                                                                // there is already a key-value pair
                                                                                // added in Map.
        System.out.println(languages.get("Java"));

        /**
         * Use the keySet() method to loop through the keys in the Map and we can print the
         * values of those keys
         **/

        for (String key:languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }

        System.out.println("==========================================");
        languages.remove("Lisp");
        if (languages.remove("Javascript", "A front-end language")) {
            System.out.println("Javascript removed from the Map");
        } else {
            System.out.println("Javascript not removed. Key/Value pair not found in the Map");
        }
        for (String key:languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }
    }
}
