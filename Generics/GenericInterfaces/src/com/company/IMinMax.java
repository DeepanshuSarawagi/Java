package com.company;

public interface IMinMax<T extends Comparable<T>> {
    /**
     * In general, a generic interface is created in the same like how a generic class is created. In this case, the
     * type parameter is T and is extended with  ; its upper bound is Comparable. As seen earlier, Comparable is an
     * interface defined by java.lang that specifies how objects are compared. Its type parameter specifies the type of
     * objects being compared.
     */
    T Min();
    T Max();
}
