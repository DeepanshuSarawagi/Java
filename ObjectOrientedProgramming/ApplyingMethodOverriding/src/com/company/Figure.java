package com.company;

public class Figure {
    private int dim1;
    private int dim2;

    public Figure(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    public int area() {
        System.out.println("Area cannot be calculated for undefined figure");
        return 0;
    }

    public int getDim1() {
        return dim1;
    }

    public int getDim2() {
        return dim2;
    }
}
