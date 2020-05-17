package com.company;

public class Team implements Comparable<Team>{
    private String name;
    private int won=0;
    private int draw=0;
    private int lost=0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void matchResult(Team opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore ) {
            this.won++;
        } else if (ourScore < theirScore) {
            this.lost++;
        } else {
            this.draw++;
        }
        if (opponent != null) {
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (this.won * 2) + this.draw;
    }

    @Override
    public int compareTo(Team team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        }
        return 0;
    }
}
