package p1;

public class SamePackage {
    SamePackage() {
        Protection p = new Protection();
        System.out.println("n = " + p.n); // you can access member of the another class in same packahe by creating an
                                         // instance of it and and accessing the member by using that instance

//        System.out.println("n_pri = " + p.n_pri ); // This wont work since you cannot access a private member of the
//                                                      another class in same package

        System.out.println("n_pro = " + p.n_pro);
        System.out.println("n_pub = " + p.n_pub);
    }
}