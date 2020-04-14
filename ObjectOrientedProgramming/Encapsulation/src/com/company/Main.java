package com.company;

public class Main {

    public static void main(String[] args) {
	    Player player = new Player();
	    player.name = "Deep";
	    player.health = 20;
	    player.weapon = "sword";

	    int damage = 10;
	    player.loseHealth(damage);
        System.out.println("Health remaining = " + player.healthRemaining());
        damage = 11;
		player.loseHealth(damage);
		System.out.println("Health remaining = " + player.healthRemaining());
    }
}
