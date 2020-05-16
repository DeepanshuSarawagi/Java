package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList myInteger = new ArrayList();
        for (int i=0; i<6; i++) {
            myInteger.add(i);  // We are getting this warnings because we have not specified what type of Objects we are
                               // going to store in ArrayList. Hence, warning is asking us to generify.
        }
        printDoubled(myInteger);

        // Generics part 2
        System.out.println();
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        // Create a team and add player to it
        Team adelaideCrows = new Team("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
        adelaideCrows.addPlayer(pat);
        adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayers());

    }

    private static void printDoubled(ArrayList n){
        for (Object i : n) {
            System.out.println((Integer) i*2);

        }
    }
}
