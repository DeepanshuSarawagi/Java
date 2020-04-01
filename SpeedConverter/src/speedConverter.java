public class speedConverter {

    public static long toMilesPerHour(double kilometersPerHour) {

        if (kilometersPerHour < 0){
            return -1;
        } else {

            return Math.round(kilometersPerHour / 1.609d);
        }
    }

    public static void printConversion(double kilometersPerHour) {

        if (kilometersPerHour < 0 ) {

            System.out.println("Invalid Input");
        } else {
            long milesPerHour = toMilesPerHour(kilometersPerHour);
            System.out.println(kilometersPerHour + " Km/h = " + milesPerHour + " mi/h");
        }
    }
}