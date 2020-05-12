package com.company;

public abstract class Figure {
    /*
    A class is an abstract if its method defined are not able to provide meaningful implmentation.
    You cannot create an object of type abstract class.
    Neither can you instantiate an abstract class.

     */
    double dim1;
    double dim2;

    public Figure(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    public abstract double area();
}
