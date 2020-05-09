package com.company;

public class Volume {
    private double width;
    private double height;
    private double depth;

    double volume() {
        return width*height*depth;
    }

    // Using parametrized method to set the dimensions of Box

    void setDim(double w, double h, double d) {
        width = w;
        height = h;
        depth = h;
    }
}

class BoxDemo3{
    public static void main(String[] args) {
        Volume box1 = new Volume();
        Volume box2 = new Volume();

        box1.setDim(10, 15, 20);
        box2.setDim(12, 24, 19);

        System.out.println("Volume of box1 is: " + box1.volume());
        System.out.println("Volume of box2 is: " + box2.volume());
    }
}
