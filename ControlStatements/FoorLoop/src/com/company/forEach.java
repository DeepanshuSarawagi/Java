package com.company;

public class forEach {
    public static void main(String[] args) {
        // The general type of foreach version of for is shown here.
        // for (type itr-var: collections) statement-block
        // Here, type specifies the type and itr-var specifies the iteration variable that will receive the elements
        // from the collections one at a time. The collection being cycled through is specified by "collections" in for
        // statement. There are various types of collections which can be used in for loop, most commonly used is an
        // Array for example.

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        System.out.println("The sum of array elements is " + sum);
    }
}
