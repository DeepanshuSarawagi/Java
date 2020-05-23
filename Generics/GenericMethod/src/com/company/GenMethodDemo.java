package com.company;

public class GenMethodDemo {
    /**
     * It is possible to create a generic method that uses one more type parameter of its own. Furthermore, it is
     * possible to create a generic method within a non-generic class.
     * The following static generic method determines if an object is a member of an array. It can be used with any type
     * of object as long as the array contains that type of object
     */
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (V v : y) if (x.equals(v)) return true;

        return false;
    }
}
