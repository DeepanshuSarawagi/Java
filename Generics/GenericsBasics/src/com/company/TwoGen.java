package com.company;

public class TwoGen<T, V> {
    /**
     * We can also create a class with generic parameters. In order to do that, we need to pass the Type parameters
     * comma separated. And then while invoking the object, we need to pass two type arguments.
     */
    private T obj1;
    private V obj2;

    public TwoGen(T obj1, V obj2) {  // Initializing constructor with two Type parameters
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getObj1() {
        return obj1;
    }

    public V getObj2() {
        return obj2;
    }

    public void showType() {
        System.out.println("Object of type T is " + obj1.getClass().getName());
        System.out.println("Object of type V is " + obj2.getClass().getName());
    }
}
