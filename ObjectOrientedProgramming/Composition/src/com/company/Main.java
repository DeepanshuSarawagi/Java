package com.company;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("220B", "Dell", "240V", dimensions);

        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27,
                new Resolution(2540, 1550));

        Motherboard theMotherboard = new Motherboard("BJ-200", "ASUS", 4, 6,
                "v2.44");

        PC thePC = new PC(theCase, theMonitor, theMotherboard);

        // how to access methods of objects using Composition
//        thePC.getMonitor().drawPixel(10, 5, "black");
//        thePC.getTheCase().pressPowerButton();
//        thePC.getMotherboard().loadProgram("Mac OSX");

        thePC.powerUp();
        thePC.loadProgram();

        Wall wall1 = new Wall("East");
        Wall wall2 = new Wall("West");
        Wall wall3 = new Wall("South");
        Wall wall4 = new Wall("North");

        Ceiling ceiling = new Ceiling(12, "Cream");

        Bed bed = new Bed("Modern", 4,2,3,1);

        Lamp lamp = new Lamp("Classic", false, 75);

        System.out.println();

        Bedroom bedroom = new Bedroom("Deeps", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
        bedroom.makeBed();
        bedroom.getLamp().turnOnLamp();

    }
}
