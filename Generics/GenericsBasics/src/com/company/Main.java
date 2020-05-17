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


        // Create object of NonGeneric type

        NonGen nonGen = new NonGen(45);
        nonGen.showType();
        int v = (Integer) nonGen.getOb();  // remember that while getting the value, we need to explicitly cast it.
        System.out.println("Value of object nonGen is " + v);

        System.out.println();
        nonGen = new NonGen("Non-Generic Object");
        String s = (String) nonGen.getOb();
        System.out.println("Value of object is " + s);
        nonGen.showType();

        // Create Generics Object with two type parameters
        System.out.println();
        TwoGen<Integer, String> twoGen = new TwoGen<>(23, "Generics");

        System.out.println("Value of argument 1 is " + twoGen.getObj1());
        System.out.println("Value of argument 2 is " + twoGen.getObj2());
        twoGen.showType();
    }
}
