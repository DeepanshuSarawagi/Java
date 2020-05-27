package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("SPI Cinemas", 8, 12);
//        theatre.getSeats();
//        if (theatre.reserveSeat("H10")) {
//            System.out.println("Please pay.");
//        } else {
//            System.out.println("Seat is already taken.");
//        }
//
//        if (theatre.reserveSeat("A10")) {
//            System.out.println("Please pay.");
//        } else {
//            System.out.println("Seat is already taken.");
//        }

        // Create a new list and copy the theatre seats in the ArrayList
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("======================================");
    }
}
