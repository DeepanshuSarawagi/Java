package com.company;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows-1);
//        System.out.println("Last row is " + lastRow);
        for (char row = 'A'; row<=lastRow; row++) {
            for (int seatNum=1; seatNum<=seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        // Implement binary search using Java source code
//        int low = 0;
//        int high = seats.size()-1;
//
//        while (low <= high) {
//            System.out.print(".");
//            int mid = (low + high) / 2;
////            System.out.println("mid is now " + mid);  // TODO remove this line after testing
//            Seat midVal = seats.get(mid);
////            System.out.println("midVal is " + midVal.getSeatNumber());  // TODO remove this line after testing
//            int cmp = midVal.getSeatNumber().compareTo(seatNumber);
////            System.out.println("cmp is now " + cmp);  // TODO remove this line after testing
//            if (cmp < 0) {
//                low = mid + 1;
////                System.out.println("low is now " + low);  // TODO remove this line after testing
//            } else if (cmp > 0) {
//                high = mid - 1;
////                System.out.println("high is now " + high);  // TODO remove this line after testing
//            } else {
//                return seats.get(mid).reserve();
//            }
//        }
//        System.out.println("There is no seat " + seatNumber);
//        return false;
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

//        for (Seat seat : seats) {
//            System.out.print(".");
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//
//        if (requestedSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        } else {
//            return requestedSeat.reserve();
//        }
    }

    // for testing
    public Collection<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + this.seatNumber + " reserved.");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of " + this.seatNumber + " cancelled.");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return this.seatNumber;
        }
    }
}
