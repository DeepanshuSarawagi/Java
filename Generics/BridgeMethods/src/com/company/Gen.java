package com.company;

public class Gen<T> {
    protected T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
class Gen2 extends Gen<String> {
    /**
     * Notice that we have extended Gen2 from Gen of a specific type String.
     * Furthermore, getOb() return type is String which is overridden in the subclass.
     * All this is perfectly fine, only trouble is expected form of getOb() will be Object getOb() { ....
     * To handle this problem, compiler generates a bridge method with the preceding signature that calls the String
     * version. Thus, if you examine the class file for Gen2 using javap, you will see the following methods
     *   public com.company.Gen2(java.lang.String);
     *   public java.lang.String getOb();
     *   public java.lang.Object getOb();  // Bridge method
     *
     *   As you can see, bridge method is included when the java class is compiled.
     **/
    public Gen2(String ob) {
        super(ob);
    }

    @Override
    public String getOb() {
        System.out.print("String getOb() called: ");
        return this.ob;
    }
}
