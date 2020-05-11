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

    public BoxWeight() {
        this.weight = -1;
    }

    public BoxWeight(BoxWeight box) {
        super(box);
        this.weight = box.weight;
    }

    public BoxWeight(double len, double weight) {
        super(len);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

}

class ShipmentCost extends BoxWeight {
    private double cost;

    // Constructor when all parameters are defined
    public ShipmentCost(double width, double height, double depth, double weight, double cost) {
        super(width, height, depth, weight);
        this.cost = cost;
    }

    // Constructor when Shipment Object is passed as an argument
    public ShipmentCost(ShipmentCost shipmentCost) {
        super(shipmentCost);
        this.cost = shipmentCost.cost;
    }

    // Constructor when no arguments are passed
    public ShipmentCost() {
        this.cost = -1;
    }

    //Shipment when length of cube is passed
    public ShipmentCost(double len, double weight, double cost) {
        super(len, weight);
        this.cost = cost;
    }

    // Use getters to display the cost of shipment

    public double getCost() {
        return cost;
    }
}

class BoxWeightDemo {
    public static void main(String[] args) {
        double vol;
        BoxWeight myBox1 = new BoxWeight(12.5, 14.5, 10.6, 25);
        BoxWeight myBox2 = new BoxWeight(16.5, 9.5, 11.8, 20);
        vol = myBox1.volume();
        System.out.println("Volume of myBox1 is " + vol + " and weight of myBox1 is " + myBox1.getWeight() );
        vol = myBox2.volume();
        System.out.println("Volume of myBox2 is " + vol + " and weight of myBox2 is " + myBox2.getWeight() );

        BoxWeight myBox3 = new BoxWeight(myBox1);
        System.out.println("Volume of myBox3 is " + myBox3.volume() + " and weight of myBox3 is " + myBox3.getWeight());

        BoxWeight myBox4 = new BoxWeight(10, 15.5);
        vol = myBox4.volume();
        System.out.println("Volume of myBox4 is " + vol + " and weight of myBox4 is " + myBox4.getWeight() );

        BoxWeight myBox5 = new BoxWeight();
        vol = myBox5.volume();
        System.out.println("Volume of myBox5 is " + vol + " and weight of myBox4 is " + myBox5.getWeight() );

        // Create shipmentCost objects

        ShipmentCost shipmentCost1 = new ShipmentCost();
        vol = shipmentCost1.volume();
        System.out.println("Volume of shipment 1 is " + vol + " weight is " + shipmentCost1.getWeight() + " cost is" +
                " $" + shipmentCost1.getCost());

        ShipmentCost shipmentCost2 = new ShipmentCost(15.0, 12.5, 25.2, 18, 20.0);
        vol = shipmentCost2.volume();

        System.out.println("Volume of shipment 2 is " + vol + " weight is " + shipmentCost2.getWeight() + " cost is" +
                " $" + shipmentCost2.getCost());

        ShipmentCost shipmentCost3 = new ShipmentCost(15.5, 50, 60);
        vol = shipmentCost3.volume();

        System.out.println("Volume of shipment 3 is " + vol + " weight is " + shipmentCost3.getWeight() + " cost is" +
                " $" + shipmentCost3.getCost());

        ShipmentCost shipmentCost4 = new ShipmentCost(shipmentCost2);
        vol = shipmentCost4.volume();
        System.out.println("Volume of shipment 4 is " + vol + " weight is " + shipmentCost4.getWeight() + " cost is" +
                " $" + shipmentCost4.getCost());
    }
}