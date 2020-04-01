public class Main {

    public static void main(String[] args) {

        speedConverter.printConversion(10.5);
        speedConverter.printConversion(-1);
        long miles = speedConverter.toMilesPerHour(10.5);
        System.out.println("Miles = " + miles);

        miles = speedConverter.toMilesPerHour(-100.5);
        System.out.println("Miles = " + miles);
    }
}
