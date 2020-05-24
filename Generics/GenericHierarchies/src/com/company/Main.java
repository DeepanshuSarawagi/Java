package com.company;

public class Main {

    public static void main(String[] args) {
        Gen<Integer> genObj1 = new Gen<>(100);
        System.out.println(genObj1.getOb());

        Gen2<Integer, String> genObj2 = new Gen2<>(99, "Example");
        System.out.println(genObj2.getOb());
        System.out.println(genObj2.getOb2());
    }
}
