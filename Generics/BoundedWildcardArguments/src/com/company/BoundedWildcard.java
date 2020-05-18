package com.company;

import java.util.concurrent.ForkJoinPool;

public class BoundedWildcard {
    static void showXY(Coords<?> c) {
        System.out.println("X Y coordinates are: ");
        for (int i=0; i<c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
        }
    }
    static void showXYZ(Coords<? extends ThreeD> c) {
        System.out.println("X Y Z coordinates are: ");
        for (int i=0; i<c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " +
                               c.coords[i].y + " " +
                               c.coords[i].z);
        }
    }

    static void showAll(Coords<? extends FourD> c) {
        System.out.println("X Y Z T coordinates are: ");
        for (int i=0; i<c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " +
                    c.coords[i].y + " " +
                    c.coords[i].z + " " +
                    c.coords[i].t);
        }
    }
}
