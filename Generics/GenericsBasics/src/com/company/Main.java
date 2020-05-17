package com.company;

public class Main {

    public static void main(String[] args) {
	    // Create a Gen object of type Integer
        Gen<Integer> iOb = new Gen<>(88);

        // show the type of data used by iOb
        iOb.showType();

        // get the value of iOb. Notice that no cast is needed.
        System.out.println("Value is " + iOb.getOb());

        // Create a Gen object for String
        Gen<String> strObj= new Gen<>("Generics test");

        // show the type of data used by strObj
        strObj.showType();

        // get value of strObj
        System.out.println("Value of strObj is " + strObj.getOb());
    }
}
