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

class Team{
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<Player> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(Player player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " is picked for team " + this.name);
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