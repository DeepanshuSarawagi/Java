package com.company;

public interface Alpha {
    default void reset() {
        System.out.println("Reset method is being called from Alpha Interface");
    }
}
