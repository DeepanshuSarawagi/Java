package com.company;

public class Box {
    double width;
    double height;
    double depth;

    // create method to display volume of the box
    void volume() {
        System.out.println("Volume of the box is: " + (width*height*depth));
    }

    double boxVolume() {
       return width*height*depth;
    }
}

class BoxDemo {
    public static void main(String[] args) {
        Box myBox1 = new Box();
        Box myBox2 = new Box();
//        double volume;

        // assign value to myBox1`s instance variables
        myBox1.width = 10;
        myBox1.height = 15;
        myBox1.depth = 20;

        /*
        Assign different value to myBox2`s instance variables
         */

        myBox2.width = 12;
        myBox2.height = 15;
        myBox2.depth = 8;

        // compute volume of first box

//        volume = myBox1.width * myBox1.height * myBox1.depth;
//        System.out.println("Volume of myBox1 is: " + volume);

        myBox1.volume();

        // compute volume of second box

//        volume = myBox2.width * myBox2.height * myBox2.depth;
//        System.out.println("Volume of myBox2 is: " + volume);
        myBox2.volume();

    }
}

class BoxDemo2 {
    public static void main(String[] args) {

        Box box1 = new Box();
        Box box2 = new Box();
        double vol;

        box1.width = 23;
        box1.height = 15;
        box1.depth = 20;

        box2.width = 18;
        box2.height = 24;
        box2.depth = 14;

        vol = box1.boxVolume();
        System.out.println("Volume of box1 is: " + vol);

        vol = box2.boxVolume();
        System.out.println("Volume of box2 is: " + vol);
    }
}