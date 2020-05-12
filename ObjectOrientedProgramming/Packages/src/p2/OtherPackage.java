package p2;

public class OtherPackage {
    OtherPackage() {
        System.out.println("Other package constructor");
        p1.Protection p = new p1.Protection();

//        System.out.println("n = " + p.n);  // cannot access non-public member of a class from a different package
//        System.out.println("n_pri = " + p.n_pri);  // cannot access private member of a class from a different package
//        System.out.println("n_pro = " + p.n_pro);  // cannot access protected member of a class from a diff package
        System.out.println("n_pub = " + p.n_pub); // can access public member of a class from a different package
    }
}
