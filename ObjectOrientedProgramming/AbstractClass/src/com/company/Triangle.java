package com.company;

public class Triangle extends Figure{
    public Triangle(double dim1, double dim2) {
        super(dim1, dim2);
    }
    public double area() {
        return this.dim1 * this.dim2/2;
    }
}
