package com.company;

public class A {
    // this is a Nested Interface
    public interface NestedIf{
        boolean isNotNegative(int x);
    }
}

// Class B implements the nested interface
class B implements A.NestedIf {
    @Override
    public boolean isNotNegative(int x) {
        return x >= 0;
    }
}
