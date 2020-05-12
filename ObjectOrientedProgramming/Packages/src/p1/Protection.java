package p1;

public class Protection {
    int n = 1;  // member of the class with no modifier
    private int n_pri = 2;  // private member of the class
    protected int n_pro = 3; // protected member of the class
    public int n_pub = 4; // public member of the class

    public Protection() {
        System.out.println("Base constructor");
        System.out.println("n = " + n);
        System.out.println("n_pri = " + n_pri);
        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub);
    }
}
