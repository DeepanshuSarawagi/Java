package com.company;

public class MyClass3 implements Gamma{
    public MyClass3() {
        System.out.println("Default MyClass3 constructor");
    }
    // Notice that we are not Overriding the reset() method here. Hence, the default reset() method will be called from
    // the Alpha or Gamma interface when invoked using the class` object.
}
