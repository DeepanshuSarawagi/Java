package com.company;

public interface Beta {
    default void reset() {
        System.out.println("Reset called from Beta interface");
    }
}
