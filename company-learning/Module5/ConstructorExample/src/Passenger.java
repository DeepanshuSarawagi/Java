public class Passenger {
    private int freeBags;
    private int checkedInBags;

    public Passenger(int freeBags) {
        this.freeBags = freeBags;
    }

    public Passenger(int freeBags, int checkedInBags) {
        this.checkedInBags = checkedInBags;
    }

    public int getFreeBags() {
        return freeBags;
    }

    public int getCheckedInBags() {
        return checkedInBags;
    }
}
