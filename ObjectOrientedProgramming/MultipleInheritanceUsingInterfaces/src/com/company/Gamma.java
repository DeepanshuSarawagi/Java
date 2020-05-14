package com.company;

public interface Gamma extends Alpha{
    /*
    Here we have inherited the Gamma interface from the Alpha interface. And we can override the reset() method here.
     */
    default void reset() {
        Alpha.super.reset();  // We can also forcefully call the reset method from the Alpha interface using the super
                              // keyword. Comment out line eight to experiment.
        System.out.println("Reset method called from Gamma Interface");  // comment out this line to experiment further
    }
}
