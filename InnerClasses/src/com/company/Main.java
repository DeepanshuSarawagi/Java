package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");
    private static Button btnScan = new Button("Scan");

    public static void main(String[] args) {
        GearBox mcLaren = new GearBox(6);
//        GearBox.Gear first = mcLaren.new Gear(1, 12.3);
////        GearBox.Gear second = new GearBox.Gear(2, 15.6);  // this will not work. Incorrect syntax
////        GearBox.Gear third = new mcLaren.Gear(3, 20.5);   // this will not work. Incorrect syntax
//
//        System.out.println(first.driveSpeed(1000));

        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(3);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(5);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(5000));

        // Creating instances to learn about local classes in Java

        class clickListener implements Button.OnClickListener {
            public clickListener() {
                System.out.println("I have been attached.");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked.");
            }
        }
        btnPrint.setOnClickListener(new clickListener());
        btnScan.setOnClickListener(new clickListener());
        listen();
    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
                    btnScan.onClick();
            }
        }
    }
}
