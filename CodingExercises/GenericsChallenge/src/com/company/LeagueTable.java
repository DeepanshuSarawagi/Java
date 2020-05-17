package com.company;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

public class LeagueTable<T extends Team> {
    private ArrayList<T> league;
    private String name;

    public LeagueTable(String name) {
        this.name = name;
        this.league = new ArrayList<>();
    }
    public boolean add(T team) {
        if (league.contains(team)) {
            System.out.println(team.getName() + " already exists");
            return false;
        } else {
            this.league.add(team);
            return true;
        }
    }
    public void TeamRanking() {
        Collections.sort(league);
        for (T t: league) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
