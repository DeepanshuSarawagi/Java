package com.company;

public class MyClass<T extends Comparable<T>> implements IMinMax<T> {
    T[] vals;

    public MyClass(T[] vals) {
        this.vals = vals;
    }

    @Override
    public T Min() {
        T v = this.vals[0];
        for (int i=0; i<vals.length; i++) {
            if (vals[i].compareTo(v) < 0) {
                v = vals[i];
            }
        }
        return v;
    }

    @Override
    public T Max() {
        T v = this.vals[0];
        for (int i=0; i<vals.length; i++) {
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}
