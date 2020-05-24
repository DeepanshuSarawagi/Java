package com.company.deepanshu;

public class Main {
    /**
     * In this example we are going to compare the runtime hierarchy of Generic classes. We will the instanceof method
     * to determine whether the object created is instance of a specific class.
     */
    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(100);
        Gen2<Integer> iOb2 = new Gen2<>(90);
        Gen2<String> strOb = new Gen2<>("Generic Test");

        if (iOb2 instanceof Gen2<?>) {
            System.out.println("iOb2 is instance of Gen2<T>");
        }
        if (strOb instanceof Gen2<?>) {
            System.out.println("strOb is instance of Gen2<T>");
        }

        if (iOb instanceof Gen2<?>) {
            System.out.println("iOb is instance of Gen<T>");
        } else {
            System.out.println("iOb is instance of Gen<T>");
        }

        if ((iOb2 instanceof Gen<?>) && (strOb instanceof Gen<?>)) {
            System.out.println("Both the Gen2<T> objects are instance of Gen<T> superclass as well.");
        }
    }
}
