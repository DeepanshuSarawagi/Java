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

class Team<T>{
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
            System.out.println(((Player) player).getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(((Player) player).getName() + " is picked for team " + getName());
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            this.won++;
        } else if (ourScore == theirScore) {
            this.tied++;
        } else {
            this.lost++;  // saving the ourTeam`s score
        }

        if (opponent != null) {
            opponent.matchResult(null, theirScore, ourScore);  // saving the opponent team score
        }
    }

    public int ranking() {
        return (this.won * 2) + this.tied;
    }
}