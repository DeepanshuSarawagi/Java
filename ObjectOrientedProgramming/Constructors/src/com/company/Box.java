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

    // Overloading a constructor
    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    Box(double len) {
        width = height = depth = len;
    }

    double volume() {
        return width*height*depth;
    }

}

class BoxDemo6{
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();
        Box myCube = new Box(12.5);

        // Creating new object/instance of class Box using its overloaded Contructor (Constructor with parameter)

        Box box3 = new Box(15, 23, 31);

        System.out.println("Volume of box1 is: " + box1.volume());
        System.out.println("Volume of box2 is: " + box2.volume());
        System.out.println("Volume of box3 is: " + box3.volume());
        System.out.println("Volume of cube is: " + myCube.volume());
    }
}

