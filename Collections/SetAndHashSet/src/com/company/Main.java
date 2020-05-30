package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);  // temp is now Mars
        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);  // temp is still Mars

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);  // temp is now Jupiter
        tempMoon = new HeavenlyBody("Ganymede", 7.10);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);  // temp is still Jupiter
        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);  // temp is now Jupiter

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets: ");
        for (HeavenlyBody planet: planets) {
            System.out.println("\t" + planet.getName());
            for (HeavenlyBody moon: planet.getSatellites()) {
                System.out.println("\t\t" + moon.getName());
            }
        }

        // To generate a Union Set of Moons of all the planets, we can use the addAll method
        Set<HeavenlyBody> Moons = new HashSet<>();
        for (HeavenlyBody planet:planets) {
            Moons.addAll(planet.getSatellites());
        }

        System.out.println("====================================");

        // Printing all the Moons
        for (HeavenlyBody moon: Moons) {
            System.out.println(moon.getName());
        }
    }
}
