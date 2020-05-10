package com.company;

public class Main {

    public static void main(String[] args) {
	// Notice how array must be created to hold the arguments.

        int[] n1 = {10};
        int[] n2 = {1, 2, 3};
        int[] n3 = {};

        PassArray.vaTest(n1);
        PassArray.vaTest(n2);
        PassArray.vaTest(n3);

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
