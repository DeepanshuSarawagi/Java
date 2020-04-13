package com.company;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

//    private Dog(String name, int brain, int body, int size, int weight ) {
//        super(name, brain, body, size, weight);
//    }

    // Since all animals have brain and body, we need not define it as a parameter in Dog Constructor which extends
    // the super class Animal. We will remove those parameters in the constructor and replace in super() method as 1.

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat ) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Dog.chew() is called");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() is called");
        chew();
        super.eat();
    }
}
