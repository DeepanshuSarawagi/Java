package com.company;

public class Main {

    public static void main(String[] args) {
        Integer[] iNums = {1, 2, 3, 4, 5 };
        Stats<Integer> statsInteger = new Stats<>(iNums);
        System.out.println("Average of statsInteger is " + statsInteger.average());
        Double[] dNums = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> statsDouble = new Stats<>(dNums);
        System.out.println("Average of statsDouble is " + statsDouble.average());
        Float[] fNums = {1.0F, 2.0F, 3.0F, 4.0F, 5.0F};
        Stats<Float> statsFloat = new Stats<>(fNums);
        System.out.print("Is average of statsInteger and statsDouble same? ");
        if (statsInteger.isSameAvg(statsDouble)){
            System.out.println(" Yes.");
        } else {
            System.out.println(" No. ");
        }
        System.out.print("Is average of statsInteger and statsFloat same? ");
        if (statsInteger.isSameAvg(statsFloat)){
            System.out.println(" Yes.");
        } else {
            System.out.println(" No. ");
        }
        String className = statsInteger.getClass().getName();
        System.out.println(className);
        String[] listClassName = className.split("\\.");
        System.out.println("Actual class name is " + listClassName[listClassName.length-1]);
    }
}
