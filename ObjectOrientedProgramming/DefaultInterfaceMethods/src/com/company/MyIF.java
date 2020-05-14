package com.company;

public interface MyIF {
    int getNumber();
    /*
    Starting JDK8, it is possible we are able to define the body of method in a Interface. By preceding the interface
    name with default keyword, we can define a method. Any class which implements this interface may not implement this
    method (meaningful implementation).
     */
    default String getString() {
        return "Default String";
    }
}
