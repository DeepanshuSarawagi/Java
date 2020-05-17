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
        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);      // This wont comile since parameter of type FootballPlayer is specified
//        adelaideCrows.addPlayer(beckham);  // This wont compile since we have specified the Type Parameter to be of
//                                              type FootballPlayer

        System.out.println(adelaideCrows.numPlayers());

        // To overcome the errors in the commented line we can do this
        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Bulls");
        baseballTeam.addPlayer(pat);

//        Team<String> brokenTeam = new Team<>("this wont work");
//        brokenTeam.addPlayer("beckham");
          // Line 34 and 35 will not throw any compile time error but it will throw runtime error since Java cannot cast
          // an object of type String to type Player.

    }

    private static void printDoubled(ArrayList n){
        for (Object i : n) {
            System.out.println((Integer) i*2);

        }
    }
}
