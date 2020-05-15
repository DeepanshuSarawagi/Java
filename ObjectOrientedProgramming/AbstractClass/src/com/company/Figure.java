package com.company;

public abstract class Figure {
    /*
    A class is an abstract if its method defined are not able to provide meaningful implementation.
    You cannot create an object of type abstract class.
    Neither can you instantiate an abstract class.
    Also you cannot declare abstract constructors or abstract static methods.
    Any subclass of an abstract superclass must override all the abstract methods defined in the superclass by providing
    meaningful implementation or be declared as an abstract itself.
     */
    double dim1;
    double dim2;

    public Figure(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    public abstract double area();  // abstract method. Meaningful implementation in sub-class is mandatory
}
