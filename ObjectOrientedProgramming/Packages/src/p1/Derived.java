package p1;

public class Derived extends Protection{
    Derived() {
        System.out.println("Derived constructor");
        System.out.println("n = " + n);
//        System.out.println("n_pri = " + n_pri); this will not compile hence we have commented it out. You cannot
//                                                access the private member of the superclass even if the subclass in
//                                                same package.

        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub);
    }
}
