package com.company;

public class Box {
    private double width;
    private double height;
    private double depth;

    public Box() {
        this.width = -1;
        this.height = -1;
        this.depth = -1;
    }

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box(Box box) {
        this.width = box.width;
        this.height = box.height;
        this.depth = box.depth;
    }

    public Box(double len) {
        this.width = this.height = this.depth = len;
    }

    double volume() {
        return this.width * this.height * this.depth;
    }
}
class BoxWeight extends Box {
    private double weight;

    public BoxWeight(double width, double height, double depth, double weight) {
        super(width, height, depth);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

}

class BoxWeightDemo {
    public static void main(String[] args) {
        double vol;
        BoxWeight myBox1 = new BoxWeight(12.5, 14.5, 10.6, 25);
        BoxWeight myBox2 = new BoxWeight(16.5, 9.5, 11.8, 20);
        vol = myBox1.volume();
        System.out.println("Volume of myBox1 is " + vol + " and weight of myBox1 is " + myBox1.getWeight() );
        System.out.println();
        vol = myBox2.volume();
        System.out.println("Volume of myBox2 is " + vol + " and weight of myBox2 is " + myBox2.getWeight() );

        Box myBox3 = new Box(myBox1);
        System.out.println("Volume of myBox3 is " + myBox3.volume());
    }
}