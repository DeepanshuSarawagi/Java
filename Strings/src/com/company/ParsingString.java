package com.company;

public class ParsingString {
    public static void main(String[] args) {
        String numberAsString = "2020";
        System.out.println("numberAsString = " + numberAsString);
        int number = Integer.parseInt(numberAsString); // parsing the string to convert it to Integer datatype
        System.out.println(number);

        System.out.println();
        numberAsString = "2020.04";
        double doubleNumber = Double.parseDouble(numberAsString);
        doubleNumber += 5.456;
        System.out.println("Double number is " + doubleNumber);
    }
}
