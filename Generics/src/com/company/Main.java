package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList <Integer> myInteger = new ArrayList<>();
        for (int i=0; i<6; i++) {
            myInteger.add(i);  // We are getting this warnings because we have not specified what type of Objects we are
                               // going to store in ArrayList. Hence, warning is asking us to generify.
        }
        printDoubled(myInteger);
    }

    private static void printDoubled(ArrayList <Integer>n){
        for (Object i : n) {
            System.out.println((Integer) i*2);

        }
    }
}
