package com.company;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("SPI Cinemas", 8, 12);
        theatre.getSeats();
        if (theatre.reserveSeat("D10")) {
            System.out.println("Please pay.");
        } else {
            System.out.println("Seat is already taken.");
        }

        if (theatre.reserveSeat("A10")) {
            System.out.println("Please pay.");
        } else {
            System.out.println("Seat is already taken.");
        }

    }
}
