package com.company;

public class Gen<T> {
    protected T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
class Gen2 extends Gen<String> {
    /**
     * Notice that we have extended Gen2 from Gen of a specific type String.
     * Furthermore, getOb() return type is String which is overridden in the subclass.
     */
    public Gen2(String ob) {
        super(ob);
    }

    @Override
    public String getOb() {
        System.out.print("String getOb() called: ");
        return this.ob;
    }
}
