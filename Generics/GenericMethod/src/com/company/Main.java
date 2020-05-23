package com.company;

public class Main {

    public static void main(String[] args) {
	    Integer []  nums = {1, 2, 3, 4, 5};
        System.out.println(GenMethodDemo.isIn(2, nums));

        // Create objects of GenConstructor class
        GenConstructor obj1 = new GenConstructor(100);
        obj1.showVal();

        GenConstructor obj2 = new GenConstructor(123.2F);
        obj2.showVal();
    }
}
