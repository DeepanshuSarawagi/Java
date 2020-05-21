package com.deepanshu._static;

public class Main {
    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("First Instance");
        System.out.println(firstInstance.getName() + "'s instance number is " + StaticTest.getNumInstances());

        StaticTest secondInstance = new StaticTest("Second Instance");
        System.out.println(secondInstance.getName() + "'s instance number is " + StaticTest.getNumInstances());

        StaticTest thirdInstance = new StaticTest("Third Instance");
        System.out.println(thirdInstance.getName() + "'s instance number is " + StaticTest.getNumInstances());
    }
}
