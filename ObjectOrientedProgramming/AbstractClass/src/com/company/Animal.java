package com.company;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();
    public abstract void breath();

    public String getName() {
        return name;
    }
}

class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " eating");
    }

    @Override
    public void breath() {
        System.out.println(getName() + " is breathing.");
    }
}
abstract class Bird extends Animal implements CanFly{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking.");
    }

    @Override
    public void breath() {
        System.out.println(getName() + " Breathe in, breathe out, repeat..");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " flapping its wings");
    }
}

class Parrot extends Bird{
    public Parrot(String name) {
        super(name);
    }

}

class Penguin extends Bird{
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("I'm not very good at that. Can I go for a swim instead?");
    }
}

interface CanFly{
    public void fly();
}