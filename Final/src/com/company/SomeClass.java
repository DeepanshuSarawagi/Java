package com.company;

public class SomeClass {
    private static int classCounter;
    private String name;
    public final int InstanceNumber;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        InstanceNumber = classCounter;
        System.out.println(name + " initialized and is instance number " + InstanceNumber);
    }

    public int getInstanceNumber() {
        return InstanceNumber;
    }
}
