package com.company;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public boolean addMoon(HeavenlyBody moon) {
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
}
