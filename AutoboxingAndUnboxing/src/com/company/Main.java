package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

class IntClass {
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // Here is how normal arrays are defined and initialised.

        String[] string = new String[10];
        int[] myInt = new int[10];

        // here is how ArrayList is defined. Remember that ArrayList accepts a class object and you cannot create
        // ArrayList of primitive datatype.

        ArrayList<String> myStringArray = new ArrayList<>();
        myStringArray.add("Deep");

        for (int i = 0; i < myStringArray.size(); i++) {
            System.out.println(myStringArray.get(i));
        }

        /* as said earlier you cannot create below ArrayList of int datatype. It will throw an error.
        * hence we have commented it out. Since ArrayList cannot accept a parameter of Integer datatype. It has to be
        * a class in itself. String is not a primitive datatype. It is a class in itself. */

//        ArrayList<int> myIntArrayList = new ArrayList<int>();

        /* Hence, to overcome this problem we can specify Integer which is a class rather than specifying a primitive
        datatype. we can do something like this. We can create a integer class and then create an ArrayList using this
        class which accepts integer values.
         */

        ArrayList<IntClass> myArrayIntClass = new ArrayList<>();
        myArrayIntClass.add(new IntClass(54));

        for (int i=0; i<myArrayIntClass.size(); i++) {
            System.out.println(myArrayIntClass.get(i).getMyValue());
        }

        /* Now instead of creating a new class for making the ArrayList accept the int values, there is a better way of
        achieving this. Here comes the concept of autoboxing and unboxing. We can use Integer class instead of int
        primitive datatype
         */

        Integer integer = new Integer(54);  // dont worry about the strike out value since this is deprecated in
        // Java 11
        // Similarly we can do this for double
        Double doubleValue = new Double(12.56);

        // Hence instead of passing primitive datatype, we can create ArrayList using Integer class.

        ArrayList<Integer> myIntArrayList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            myIntArrayList.add(Integer.valueOf(i));  // This converts the int datatype to Integer class object so that
            // we can store it in ArrayList. Basically it converts the base int type to Integer object wrapper. This is
            // called as Autoboxing.
        }

        for (int i = 0; i < myIntArrayList.size(); i++) {
            System.out.println(i + "--> " + myIntArrayList.get(i).intValue());  // This converts the Integer object and
            // returns the value in int datatype. This is called as unboxing.
        }

        // We can do something similar for double as well.
        /* Above method implemented is long way of doing it. there is a better way to achieve this.
         */

        Integer myIntValue = 56; // Integer.valueOf(56); -> Autoboxing
        int myInt1 = myIntValue; // myIntValue.intValue(); -> Unboxing


        ArrayList<Double> myDoubleArrayList = new ArrayList<>();
        for (double dbl=0.0; dbl<=10.0; dbl+=0.5) {
            myDoubleArrayList.add(Double.valueOf(dbl));
        }

        for (int i=0; i<myDoubleArrayList.size(); i++ ) {
            System.out.println(i + "--> " + myDoubleArrayList.get(i).doubleValue());
        }
    }
}
