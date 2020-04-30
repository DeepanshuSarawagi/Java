package com.company;

public class Main {

    public static void main(String[] args) {
        GearBox mcLaren = new GearBox(6);
        GearBox.Gear first = mcLaren.new Gear(1, 12.3);
//        GearBox.Gear second = new GearBox.Gear(2, 15.6);  // this will not work. Incorrect syntax
//        GearBox.Gear third = new mcLaren.Gear(3, 20.5);   // this will not work. Incorrect syntax

        System.out.println(first.driveSpeed(1000));
    }
}
