package com.company;

public class Car {

    // creating variables in classes. These are called as fields of classes.

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    // This is a setter. Created a method to let the pivate field of Car class updated
    public void setModel(String model) {
        this.model = model;
    }

    // This is a getter. To get the data of this field.
    public String getModel() {
        return this.model;
    }
}
