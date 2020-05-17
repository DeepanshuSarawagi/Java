package com.company;

public class Main {

    public static void main(String[] args) {
	    Team ManUtd = new Team("Manchester United");
	    Team ManCity = new Team("Manchester City");
	    Team Chelsea = new Team("Chelsea");
	    Team Liverpool = new Team("Liverpool");

        LeagueTable<Team> UEFA = new LeagueTable<>("UEFA");
        UEFA.add(ManCity);
        UEFA.add(ManUtd);
        UEFA.add(Chelsea);
        UEFA.add(Liverpool);

        ManUtd.matchResult(ManCity, 3, 1);
        ManUtd.matchResult(Chelsea, 5, 2);
        ManUtd.matchResult(Liverpool, 2, 4);
        Liverpool.matchResult(ManCity, 1, 1);
        Liverpool.matchResult(ManUtd, 2, 5);
        Liverpool.matchResult(Chelsea, 2, 1);
        Chelsea.matchResult(ManUtd, 0, 0);
        Chelsea.matchResult(ManCity, 1, 0);
        Chelsea.matchResult(Liverpool, 1, 1);

        UEFA.TeamRanking();
    }
}
