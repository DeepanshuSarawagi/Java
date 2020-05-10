public class CommandLine {
    // You need to execute this program as command line and pass arguments as strings
    public static void main(String[] args) {
        for (int i=0; i<args.length; i++) {
            System.out.println("args[" + i +"]: " + args[i]);
        }
    }
}
