package com.deepanshu;

import java.util.Random;
import java.util.function.Supplier;

/**
 * In this example, we are going to learn about Supplier. Supplier is yet another functional interface which returns the
 * value of type T. Hence, we use the Supplier.get() method to get the value.
 * In the below example, we have used the Supplier<Integer> interface to print the 10 random numbers.
 */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(100);
        for (int i=0; i<10; i++) {
            int j = randomSupplier.get();
            System.out.println(j);
            if (j % 2 == 0) {
                System.out.println("We got a random even number");
            }
        }
    }
}
