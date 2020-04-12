package com.company;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car();  // Creating new object of class Car and initialize it.
        Car holden = new Car();
//        System.out.println("Model is " + porsche.getModel());
        porsche.setModel("Carrera");
        System.out.println("Model is " + porsche.getModel());
    }
}
