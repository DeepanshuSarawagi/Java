package com.company;

public class MyClass<T extends Comparable<T>> implements IMinMax<T> {
    /**
     * Pay special attention to the way Type parameter T is declared in MyClass and then passed to MinMax interface.
     * Because MinMax requires a type that implements Comparable, the implementing class must specify the same bound.
     * Further once this bound has been established, there is no need to specify it again in the implements clause. In
     * fact, it would be wrong to do so. Following line is syntactically wrong
     * public class MyClass<T extends Comparable<T>> implements IMinMax<T extends Comparable<T>>
     * Once the type parameter has been established, it is simply passed to the interface without further modification
     */

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
