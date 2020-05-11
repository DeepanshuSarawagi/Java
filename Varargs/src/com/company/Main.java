package com.company;

public class Main {

    public static void main(String[] args) {
	    // Notice how array must be created to hold the arguments.
        // this old style approach does enable the vaTest() method to accept the variable length arguments, however, if
        // notice, each time we have to package the arguments in the array before calling the vaTest(). This old style
        // approach becomes tedious and error prone. The varargs feature offers the simpler and better option.

        int[] n1 = {10};
        int[] n2 = {1, 2, 3};
        int[] n3 = {};

        PassArray.vaTest(n1);
        PassArray.vaTest(n2);
        PassArray.vaTest(n3);
        System.out.println();

        // Look at the new approach using the varargs feature. Refer to class VarArgs for syntax.
        VarArgs.vaTest(10);
        VarArgs.vaTest(1,2,3,4,5,6);  // We are able to pass the desired number of arguments instead of packaging
                                          // the no. of arguments in an array and then pass that array as argument in
                                          // the calling method
        VarArgs.vaTest();
        System.out.println();
        VarArgsOverloaded.vaTest(24, 245, 531);
        VarArgsOverloaded.vaTest("VarArgsOverload", 1, 2, 5, 6,7 );
        VarArgsOverloaded.vaTest(true, false, true);
    }
}

class PassArray{
    // Beginning JDK5, Java has included a feature in which methods can take variable number of arguments. This is
    // called as varargs and short form for variable-length arguments. A method that takes variable length of arguments
    // is called variable-arity method or simple varargs method.
    // variable number of arguments are passed as array to the method as show below.
    static void vaTest(int[] v) {
        System.out.print("Number of args: " + v.length + " contents: ");

        for (int value : v) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

class VarArgs{
    static void vaTest(int ... v) {
        System.out.print("Number of args: " + v.length + " contents: ");
        for (int value: v) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

class VarArgsOverloaded{
    // Overloading VarArgs method with different parameter types or with number of arguments and type of parameters
    static void vaTest(int ... v ) {
        System.out.print("Number of args in (int ... v): " + v.length + " contents: ");
        for (int x : v) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    static void vaTest(String msg, int ... v) {
        System.out.print("Number of args in (String msg, int ..v): " + v.length + " contents: ");
        for (int x: v) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    static void vaTest(boolean ... b) {
        System.out.print("Number of args in (boolean ... b): " + b.length + " contents: ");
        for (boolean x: b) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}