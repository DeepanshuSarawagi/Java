public class StringClass {
    public static void main(String[] args) {
        String greetings = "Hello! Prerana!";
        String activity = " We are learning together on a weekend!";
        System.out.println(greetings + activity);

        /*
         * Converting Non-String types into a String type
         */

        int iVal = 100;
        String sVal = String.valueOf(iVal);
        System.out.println(sVal);
    }

}
