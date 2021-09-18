public class Flight {
    private int FlightNumber;

    public Flight() {

    }

    public Flight(int flightNumber) {
        this.FlightNumber = flightNumber;
    }
}

class CargoFlight extends Flight{
    private double MaxWeight;

    public CargoFlight(double MaxWeight, int FlightNumber) {
        super(FlightNumber);
        this.MaxWeight = MaxWeight;
    }

    public CargoFlight(int FlightNumber) {
        super(FlightNumber);
    }
}
