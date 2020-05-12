package com.company;

public class Main {

    public static void main(String[] args) {
        Figure figure = new Figure(10, 10);
        System.out.println("Area of figure is :" + figure.area());
        Figure figRef;

        Rectangle rectangle = new Rectangle(12, 14);
        figRef = rectangle;
        System.out.println("Area of rectangle is " + figRef.area());

        Triangle triangle = new Triangle(15, 10);
        figRef = triangle;
        System.out.println("Area of triangle is " + figRef.area());
    }
}
