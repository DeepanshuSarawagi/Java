package com.company;

import java.util.*;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon);  // temp is now Mars
        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon);  // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon);  // temp is now Jupiter
        tempMoon = new Moon("Ganymede", 7.10);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon);  // temp is still Jupiter
        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addSatellites(tempMoon);  // temp is now Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
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

        // Create a new HeavenlyBody object and that in planets set. Interestingly, we are going to create the object
        // with name pluto but with different orbitalPeriod and add it in Sets. Now, we may be wondering how is Set
        // going us to allow to add an object with duplicate name. We will get to that part below.

        System.out.println("====================================");

        HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
        planets.add(pluto);

        for (HeavenlyBody planet: planets) {
            System.out.println(planet);  // This will automatically invoke our toString method which we have overridden
//            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
        }

        // When you run this program you will see that we were still able to add pluto with different orbitalPeriod
        // that's because we have not overridden the equals and hashcode method. Oracle recommends overriding these
        // methods when we implement the Set and HashSet interface in our classes.

        System.out.println(equalsStrings("some string", "some String"));
        System.out.println("============================");
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        Set<String> words = new HashSet<>();

        words.addAll(Arrays.asList(arrayWords));
        for (String s : words) {
            System.out.println(s);
        }
    }

    public static boolean equalsStrings(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        } else {
            int n = string1.length();
            int i;
            char[] v1 = string1.toCharArray();
            for (Character character : v1) {
                System.out.print(character + " ");
            }
            System.out.println();
            char[] v2 = string2.toCharArray();
            for (Character character : v2) {
                System.out.print(character + " ");
            }
            System.out.println();
            for (i=0; i<=n-1;i++) {
                if (v1[i] != v2[i])
                    return false;
            }
            return true;
        }
    }
}
