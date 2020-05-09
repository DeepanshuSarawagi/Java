public class callByReference {
    public static void main(String[] args) {
        Test1 ob = new Test1(15, 20);

        System.out.println("Value of a and b before call: " + ob.a + " " + ob.b);
        ob.meth(ob);
        System.out.println("Value of a and b after call: " + ob.a + " " + ob.b);

        // as you can that objects using inside the method meth() has affected the object used as argument.
    }
}
class Test1{
    /* The other approach to pass an argument is call-by-reference. In this method, a reference to an argument (not
    value of the argument) is passed to the sub-routine. Inside the sub-routine, the refernce is used to access the
    actual argument specified in the call. This means that changes made to the parameter will change the value of
    argument used to call the sub-routine.
    when you pass an object to a method, call-by-reference is used. Thus, when you pass this reference to the method,
    the parameter that received it will refer to the same object as that referred to by the argument. Changes to the
    object inside the method do affect the object used as an argument. For example, see below code for reference
     */
    int a, b;

    public Test1(int i, int j) {
        this.a = i;
        this.b = j;
    }

    // pass an object
    void meth(Test1 o) {
        o.a *= 2;
        o.b /= 2;
    }
}
