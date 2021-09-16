public class Flight {
    private int FlightNumber;
    private char FlightClass;

    public Flight(int flightNumber) {
        this.FlightNumber = flightNumber;
    }

    @Override
    public boolean equals(Object obj) {
        Flight other = (Flight) obj;
        return ((this.FlightNumber == other.FlightNumber) && (this.FlightClass == other.FlightClass));
    }
}
