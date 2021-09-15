public class Flight {
    private int seats;
    private int passengers;

    public Flight(int seats, int passengers) {
        this.passengers = passengers;
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public int getPassengers() {
        return passengers;
    }
}
