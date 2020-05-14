package com.company;

public class MyClass implements MyIF{
    @Override
    public int getNumber() {
        return 100;
    }

    /*
    For example, we have not implemented the method getString(). Since its not implemented here, the code doesnt break
    and its default implementation is defined in Interface MyIF.
     */
}
