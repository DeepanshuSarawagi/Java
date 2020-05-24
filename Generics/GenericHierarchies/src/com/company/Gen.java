package com.company;

public class Gen<T> {
    /**
     * A Generic class can be part of generic class hierarchy just like a non-generic class. We can create a geenric
     * class and extend a subclass from it. Any type argument which is passed in the superclass must also be passed in
     * the subclass. This is similar to the way constructor arguments must be passed up by a hierarchy.
     *
     */
    T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
class Gen2<T, V> extends Gen<T> {
    V ob2;
    public Gen2(T ob, V ob2) {
        super(ob);
        this.ob2 = ob2;
    }

    public V getOb2() {
        return ob2;
    }
    /**
     * Here T is the type passed to Gen and V is the type specific to Gen2 class. V is used to declare an object called
     * ob2 and as well the return type for method getOb2().
     */
}
