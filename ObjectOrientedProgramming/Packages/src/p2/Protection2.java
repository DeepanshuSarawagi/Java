package p2;
public class Protection2 extends p1.Protection{
    Protection2() {
        System.out.println("derived other package constructor");

//        System.out.println("n = " + n); // commented out since this will work since we are in different package.
//                                           Although we have a class inherited from superclass of different package, we
//                                           cannot access member of superclass with default access modifier

//        System.out.println("n_pri = " + n_pri);  // This is a private member of superclass

        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub);
    }
}
