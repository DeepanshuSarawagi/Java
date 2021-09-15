public class Passenger {
    private int freeBags;
    private int checkedInBags;
    private int ExtraBaggage;
    private double PerBaggageFee = 0.0d;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private String firstName;
    private String lastName;

    public Passenger(String firstName, String lastName, int freeBags, int checkedInBags) {
        this.checkedInBags = checkedInBags;
        this.firstName = firstName;
        this.lastName = lastName;
        this.freeBags = freeBags;
        if (this.freeBags > 1) {
            this.checkedInBags += this.freeBags - 1;
        }
        this.ExtraBaggage = this.checkedInBags - 1;
        if (this.checkedInBags > 1) {
            this.PerBaggageFee = Math.round(this.ExtraBaggage * 15.55d);
        }
    }

    public int getFreeBags() {
        return 1;
    }

    public int getCheckedInBags() {
        return checkedInBags;
    }

    public double getPerBaggageFee() {
        return this.PerBaggageFee;
    }
}
