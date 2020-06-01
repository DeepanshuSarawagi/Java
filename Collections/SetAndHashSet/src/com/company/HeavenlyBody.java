package com.company;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyType;

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        ASTEROID,
        COMET
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public boolean addSatellites(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        String stringObj = ((HeavenlyBody) obj).getName();  // get the name of the obj in string. We have casted the obj
                                                            // passed as parameter to HeavenlyBody and then get the name
                                                            // of the object using getName() getter. We then compare the
                                                            // strings using the equals method of String class. This
                                                            // cast will not throw Java.Lang.NullPointerException since
                                                            // we are already checking if obj is null and returning
                                                            // false.
        return this.getName().equals(stringObj);
    }

    // just overriding the equals method is not enough. When we execute the main method, duplicate objects are still
    // added in the sets. That`s because we are not checking the hash code the object.
    // we will now be overriding the hash code method as well.


    @Override
    public int hashCode() {
        System.out.println("Hashcode is " + this.name.hashCode());
        return this.name.hashCode() + 57;
    }
}
