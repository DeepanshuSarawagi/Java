package com.company;

public class Main {

    public static void main(String[] args) {
	    Figure figure;

	    Rectangle rectangle = new Rectangle(12.5, 15.6);
	    figure = rectangle;
        System.out.println("Area of rectangle is " + figure.area());
        Triangle triangle = new Triangle(15.25, 22.36);
        figure = triangle;
        System.out.println("Area of triangle is " + figure.area());
        System.out.println();

        Dog dog = new Dog("Yorkie");
        dog.eat();
        dog.breath();
        System.out.println();

        Parrot parrot = new Parrot("Indian Parrot");
        parrot.eat();
        parrot.breath();
        parrot.fly();

        System.out.println();
        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
    }
}
