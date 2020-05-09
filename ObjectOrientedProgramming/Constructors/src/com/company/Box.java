package com.company;

import org.w3c.dom.ls.LSOutput;

public class Box {
    private double width;
    private double height;
    private double depth;

    Box() {
        System.out.println("Constructing box with default values..");
        this.width = 10;
        this.height = 10;
        this.depth = 10;
    }

    double volume() {
        return width*height*depth;
    }

}

class BoxDemo6{
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();

        System.out.println("Volume of box1 is: " + box1.volume());
        System.out.println("Volume of box2 is: " + box2.volume());
    }
}
