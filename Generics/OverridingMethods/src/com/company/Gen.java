package com.company;

public class Gen<T> {
    /**
     * We can also override methods in generic classes. Take a look at the following example.
     */
    protected T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        System.out.print("Gen`s getOb(): " );
        return ob;
    }
}

class Gen2<T> extends Gen<T> {
    public Gen2(T ob) {
        super(ob);
    }

    @Override
    public T getOb() {
        System.out.print("Gen2`s getOb(): ");
        return ob;
    }
}