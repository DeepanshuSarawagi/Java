package com.company;

import java.util.HashSet;
import java.util.Set;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Dog) {
            String objName = ((Dog) obj).getName();
            return this.getName().equals(objName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
}

class Labrador extends Dog {
    public Labrador(String name) {
        super(name);
    }

    // We are overriding the equals method in subclass as well. But we will face potential issues and we will comment it
    // out after testing the code in DogMain class.

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//
//        if (obj instanceof Labrador) {
//            String objName = ((Labrador) obj).getName();
//            return this.getName().equals(objName);
//        }
//        return false;
//    }

    // we have marked this class as final in super-class so that this cannot be overridden.
}

class DogMain {
    public static void main(String[] args) {
        // Create instances of Dog class and Labrador class

        Dog rover = new Dog("rover");
        Labrador rover1 = new Labrador("rover");

        System.out.println(rover.equals(rover1));
//        System.out.println(rover1.equals(rover));

        // line 58 returns false because technically, all objects of sub-class are by default the instances of
        // super-class but thats not the case with vice-versa. That is no instance of base/super class is also instance
        // of its sub-class hence the rover1.equals(rover) returns false since rover is not instance of Labrador class.

        // To overcome this method, we see a potential problem in the code. That is we are overriding the equals()
        // method sub-class. To prevent it from being overridden, we need to mark it as final. Because, when equals
        // overridden, the equals method of sub-class is called.

        // Now once the equals() method is overridden, we will see that below code returns true.

        System.out.println(rover1.equals(rover));

        // We have also overridden the hashcode() method and due to this, it only adds unique objects and in Dogs Set,
        // just one rover is added. Since we are comparing it by name. If we compare it by class then, both the rovers
        // would be added.
        Set<Dog> Dogs = new HashSet<>();
        Dogs.add(rover);
        Dogs.add(rover1);

        for (Dog dog : Dogs) {
            System.out.println(dog.getName());
        }

    }
}