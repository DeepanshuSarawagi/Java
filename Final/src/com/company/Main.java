package com.company;

public class Main {

    public static void main(String[] args) {
        SomeClass one = new SomeClass("One");
        SomeClass two = new SomeClass("Two");
        SomeClass three = new SomeClass("Three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

//        one.InstanceNumber = 4;  // This will throw an error because its a final variable and we cannot change the
//                                    value
    }
}
