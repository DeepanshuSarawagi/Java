package com.company;

public class Stats<T extends Number> {
    T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    double average() {
        double sum = 0.0;
        for (T num : nums) {
            sum += num.doubleValue();
        }
        return sum / nums.length;
    }

//    boolean isSameAvg(Stats<T> ob) {
//        return this.average() == ob.average();
//    }
    // The above code wont work becase we wont be able to compare the values of objects of two different types. For
    // example, if we are invoking the object of type Stats<Integer> then parameter ob should also be of type
    // Stats<Integer>. If the parameter and invoking objects type differ then it will throw an error. Here comes, yet
    // another important feature of generics called "wildcard argument". We need to replace the parameter Stats<T> ob
    // with Stats<?> ob. This way we are creating the Generic method isSameAvg().

    boolean isSameAvg(Stats<?> ob) {
        return this.average() == ob.average();
    }
}
