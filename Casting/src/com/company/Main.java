package com.company;

public class Main {

    public static void main(String[] args) {
        /* In this lesson we are going to learn more about casting. Casting is a technique to convert one data type to
        another. We can define a variable of int datatype and convert it to byte. Similarly we can convert float, double
        to a int data type.
        the syntax to convert a datatype into another is
        "variable_name" = (target datetype) value;
        Consider tnat we want to convert an integer datatype to byte, if the valute of int is larger than byte, it will
        be reduced modulo (remainder of the integer division by the) byte`s range
         */

        byte b;
        int i = 257;
        double d = 323.142;

        System.out.println("\n Conversion of int type to byte ");
        b = (byte) i;
        System.out.println("i and b " + i + " " + b);

        System.out.println("\n Conversion to double to int");
        i = (int) d;
        System.out.println("d and i " + d + " " + i);

        System.out.println("\n Conversion of double to byte");
        b = (byte) d;
        System.out.println("d and b " + d + " " + b);

        /* When the value 257 is cast into type byte, the value of remainder 257 % 256 is assigned to variable b which
        is 1 in this case. When d is converted to int, its fractional value is lost. Similarly, when d is converted to
        byte, its fractional component is lost and its reduced modulo 256, which is 67.

         */
    }
}
