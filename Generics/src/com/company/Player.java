package com.company;

import java.util.ArrayList;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BaseballPlayer extends Player{
    public BaseballPlayer(String name) {
        super(name);
    }
}

class FootballPlayer extends Player{
    public FootballPlayer(String name) {
        super(name);
    }
}

class SoccerPlayer extends Player{
    public SoccerPlayer(String name) {
        super(name);
    }
}

class Team<T extends Player> implements Comparable<Team<T>>{
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " is picked for team " + getName());
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;
        if (ourScore > theirScore) {
            this.won++;
            message = " beat ";
        } else if (ourScore == theirScore) {
            this.tied++;
            message = " drew with ";
        } else {
            this.lost++;  // saving the ourTeam`s score
            message = " lost to ";
        }

        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);  // saving the opponent team score
            System.out.println(this.getName() + " has won " + this.won + " matches." + opponent.getName() + " has " +
                    " won " + opponent.won + " matches.");
        }
    }

    public int ranking() {
        return (this.won * 2) + this.tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return 1;
        } else if (this.ranking() < team.ranking()) {
            return -1;
        } else {
            return 0;
        }
    }
}