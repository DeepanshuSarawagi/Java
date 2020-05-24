package com.company.deepanshu;

public class Gen<T> {
    T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
class Gen2<T> extends Gen<T>{
    public Gen2(T ob) {
        super(ob);
    }
}
