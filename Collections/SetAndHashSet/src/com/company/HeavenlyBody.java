package com.company;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
//    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
//    private final BodyTypes bodyType;
    private Key key;

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        ASTEROID,
        COMET
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name, bodyType);
    }

//    public String getName() {
//        return name;
//    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

//    public BodyTypes getBodyType() {
//        return bodyType;
//    }


    public Key getKey() {
        return key;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public boolean addSatellites(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
//        System.out.println("obj.getClass() is " + obj.getClass());
//        System.out.println("this.getClass() is " + this.getClass());
//        if (obj == null || (obj.getClass() != this.getClass())) {
//            return false;
//        }
//        String stringObj = ((HeavenlyBody) obj).getName();  // get the name of the obj in string. We have casted the obj
//                                                            // passed as parameter to HeavenlyBody and then get the name
//                                                            // of the object using getName() getter. We then compare the
//                                                            // strings using the equals method of String class. This
//                                                            // cast will not throw Java.Lang.NullPointerException since
//                                                            // we are already checking if obj is null and returning
//                                                            // false.
//        return this.getName().equals(stringObj);
        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
//            if (this.name.equals(theObject.getName())) {
//                return this.bodyType == theObject.getBodyType();
//            }
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    // just overriding the equals method is not enough. When we execute the main method, duplicate objects are still
    // added in the sets. That`s because we are not checking the hash code the object.
    // we will now be overriding the hash code method as well.

    private static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public final int hashCode() {
//        System.out.println("Hashcode is " + this.name.hashCode());
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    static final class Key{
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}
