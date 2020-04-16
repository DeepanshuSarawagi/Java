package com.company;

class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine() {
        return "Car -> startEngine()";
    }

    public String accelerate() {
        return "Car -> accelerate()";
    }

    public String brake() {
        return "Car -> brake()";
    }
}

class Mitsubishi extends Car {
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Mitsubishi -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Mitsubishi -> accelerate()";
    }

    @Override
    public String brake() {
        return "Mitsubishi -> brake()";
    }
}

class Toyota extends Car{
    public Toyota(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Toyota -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Toyota -> accelerate()";
    }

    @Override
    public String brake() {
        return "Toyota -> brake()";
    }
}

class Kia extends Car {
    public Kia(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Kia -> startEngine()";
    }

    @Override
    public String accelerate() {
        return "Kia -> accelerate()";
    }

    @Override
    public String brake() {
        return "Kia -> brake()";
    }
}
public class Main {

    public static void main(String[] args) {
	    Car car = new Car(8, "Base Car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        System.out.println();

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());
        System.out.println(mitsubishi.getName());

        System.out.println();
        Toyota toyota = new Toyota(6, "Fortuner Automatic 4WD");
        System.out.println(toyota.startEngine());
        System.out.println(toyota.accelerate());
        System.out.println(toyota.brake());
        System.out.println(toyota.getName());

        System.out.println();
        Kia kia = new Kia(6, "Seltos 4WD");
        System.out.println(kia.startEngine());
        System.out.println(kia.accelerate());
        System.out.println(kia.brake());
        System.out.println(kia.getName());

    }
}
