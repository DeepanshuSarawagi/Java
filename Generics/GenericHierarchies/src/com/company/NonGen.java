package com.company;

public class NonGen {
    /**
     * It is perfectly fine for a non-generic class to be the superclass of the generic subclasses.
     */
    private int num;

    public NonGen(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
class GenSubClass<T> extends NonGen{
    /**
     * Creating a generic subclass which extends from a non-generic superclass.
     */
    T ob;

    public GenSubClass(int num, T ob) {
        super(num);
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
