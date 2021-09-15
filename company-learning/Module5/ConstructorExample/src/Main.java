import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Flight MaaNdl = new Flight();
        Passenger Deepanshu = new Passenger("Deepanshu", "Sarawagi", 2, 3);
        Passenger Divya = new Passenger("Divya", "Mittal", 1, 2);
        MaaNdl.AddPassenger(Deepanshu);
        MaaNdl.AddPassenger(Divya);
        ArrayList<Passenger> PassengerList = MaaNdl.ListPassengersOnBoard();
        for(Passenger passenger : PassengerList) {
            System.out.println(passenger.getFirstName() + " " + passenger.getLastName() + " " + passenger.getFreeBags() +
                    " " + passenger.getCheckedInBags() + " " + passenger.getPerBaggageFee());
        }

    }
}
