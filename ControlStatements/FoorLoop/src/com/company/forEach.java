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

        /* Although the for-each for loop interates until all the elements in the for loop is examined, it is possible
        to terminate the loop early using the break statement.
         */
        sum = 0;  // re-initialising the sum = 0 for working on below example.

        for (int i: nums) {
            sum += i;
            if (i == 5) {
                break;
            }
        }
        System.out.println("The value of sum of first 5 elements is " + sum);

        for (int i =1; i<nums.length; i++) {
            nums[i] = i * 2;
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
