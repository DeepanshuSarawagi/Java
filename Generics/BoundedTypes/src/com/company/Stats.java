package com.company;

//public class Stats<T> {  // Notice that we are extending T with superclass Number by creating a bound of upper limit
                          // to ensure that we are passing objects of type Number alone.
public class Stats<T extends Number> {
    T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    public double average() {
        double sums = 0.0;
        for (int i=0; i<nums.length; i++) {
//            sums += nums[i].doubleValue();  // this will throw an error during compile time because compiler has no
//                                              way to understand we are trying to create Stats objects using only
//                                              numeric data type. Hence, we need to tell compiler to pass only numeric
//                                              values to type T. Furthermore, we need to ensure that only numeric types
//                                              are actually passed. To handle such situation, java provides bounded
//                                              types. When specifying a type parameter, you can create an upper bound
//                                              by extending T with Number superclass. <T extends superclass>
            sums += nums[i].doubleValue();   // doubleValue is the method which is available to all the subclasses of
                                            // type Number

        }
        return sums / nums.length;
    }
}
