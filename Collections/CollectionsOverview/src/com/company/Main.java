package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.getSeats());
        printList(seatCopy);

        // Here we have made the shallow copy of Seat objects in the new ArrayList. although, its just a copy but these
        // are just two references to same objects. If we try to reserve the seat using the seatCopy object reference
        // and again reserve the same seat using theatre object, it will fail. So, although we have two lists of Seat
        // objects, these are just two different references to the same object. See below example for further
        // understanding.

        seatCopy.get(1).reserve();
        if (theatre.reserveSeat("A02")) {
            System.out.println("Please pay for the seat.");
        } else {
            System.out.println("Sorry! This seat is already reserved.");
        }

        // As you can see we have reserved seat A02 seat using seatCopy object reference, and we are trying to reserve
        // the same seat again by calling the reserveSeat() method on theatre object. When you run this code, the code
        // execution will move to the else block and say that this seat is already reserved.

        // To confirm that these are two separate lists of same object references, we can print the items of the list

        Collections.reverse(seatCopy);
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seats");
        printList(theatre.getSeats());
        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy shuffled");
        printList(seatCopy);

        // Print the min and max seat
        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat is " + minSeat.getSeatNumber());
        System.out.println("Max seat is " + maxSeat.getSeatNumber());

        // Sorting the list using bubble sort
        sortList(seatCopy);
        printList(seatCopy);

        // Reverse sort items

        List<Theatre.Seat> reverseSeat = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeat);
        printList(reverseSeat);

        // Sort the seats based on price
        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);
    }

    public static void printList(Collection<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("======================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i=0; i<list.size()-1; i++) {
            for (int j=i+1; j<list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
