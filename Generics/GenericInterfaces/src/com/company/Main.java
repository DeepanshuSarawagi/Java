package com.company;

public class Main {

    public static void main(String[] args) {
	    Integer[] nums = {6, 4, 7, 9, 2, 1, 10};
	    MyClass<Integer> myInts = new MyClass<>(nums);
        System.out.println("Minimum value is " + myInts.Min());
        System.out.println("Maximum value is " + myInts.Max());

        Character[] chars = {'b', 'a', 'x', 'p', 's', 'd'};
        MyClass<Character> myChars = new MyClass<>(chars);
        System.out.println("Minimum value is " + myChars.Min());
        System.out.println("Maximum value is " + myChars.Max());
    }
}
