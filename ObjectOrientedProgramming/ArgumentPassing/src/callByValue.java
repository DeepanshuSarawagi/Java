public class callByValue {
    public static void main(String[] args) {
        Test ob = new Test();
        int a = 15, b = 20;

        System.out.println("Value of a and b before call: " + a + " " + b);
        ob.meth(a, b);
        System.out.println("Value of a and b after call: " + a + " " + b);

        // once you run the program, you will see from the output that value of a and b remains same when arguments are
        // passed to a sub-routine using call-by-value method
    }
}

class Test{
    // There are two ways in which a computer language can pass an argument to the sub-routine. call-by-value and
    // call-by-reference.
    // in call-by-value, this approach copies the value of argument into the formal parameter of the sub-routine.
    // Therefore changes made to the parameter of the sub-routine has no effect on the argument passed.

    // when you pass a primitive type to a method, it is passed as value. Thus a value of the argument is made and what
    // occurs to the parameter that receives the arguments has no effect outside the method. For example, consider the
    // following program

    void meth(int i, int j) {
        i *= 2;
        j /= 2;
    }
}
