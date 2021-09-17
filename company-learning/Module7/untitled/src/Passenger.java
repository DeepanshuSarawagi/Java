/**
 * Remember that a final class cannot be inherited to extend its properties
 */

public final class Passenger {
    private String FirstName;
    private String LastName;
    private int FreeBags;

    public Passenger() {

    }
    public Passenger(String firstName, String lastName, int freeBags) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.FreeBags = freeBags;
    }
}
