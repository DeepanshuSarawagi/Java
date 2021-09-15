import java.util.ArrayList;

public class Flight {
    private int seats;
    private int passengers;
    protected ArrayList<Passenger> PassengerList;

    public Flight() {
        this.seats = 235;
        this.passengers = 0;
        this.PassengerList = new ArrayList<>();
    }

    public Flight(int seats, int passengers) {
        this.passengers = passengers;
        this.seats = seats;
    }

    public int getSeats() {
        return this.seats;
    }

    public int getPassengers() {
        return this.passengers;
    }

    protected boolean hasRoom() {
        return this.seats > this.passengers;
    }

    protected void AddPassenger(Passenger passenger) {
        if (hasRoom()) {
            this.passengers += 1;
            this.seats -= 1;
            this.PassengerList.add(passenger);
            System.out.println("Passenger successfully added to the flight");
        } else {
            System.out.println("The Flight is already full. No additional passengers can be accommodated");
        }
    }

    protected ArrayList<Passenger> ListPassengersOnBoard() {
        return this.PassengerList;
    }
}
