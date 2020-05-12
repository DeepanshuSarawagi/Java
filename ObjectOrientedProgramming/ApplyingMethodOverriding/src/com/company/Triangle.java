package com.company;

public class Triangle extends Figure {
    public Triangle(int dim1, int dim2) {
        super(dim1, dim2);
    }

    @Override
    public int area() {
        return this.getDim1() * this.getDim2()/2;
    }
}
