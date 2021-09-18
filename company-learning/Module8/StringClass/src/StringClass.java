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

        StringBuilder sb = new StringBuilder(50);
        sb.append("Hello! I`m learning Java for the 10000th time now.");
        sb.append(" I hope to get somewhere with this learning!");
        System.out.println(sb);

    }

}
