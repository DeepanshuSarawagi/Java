package com.company;

public class Main {

    public static void main(String[] args) {
//	    Player player = new Player();
//	    player.name = "Deep";
//	    player.health = 20;
//	    player.weapon = "sword";
//
//	    int damage = 10;
//	    player.loseHealth(damage);
//        System.out.println("Health remaining = " + player.healthRemaining());
//        damage = 11;
//		player.loseHealth(damage);
//		System.out.println("Health remaining = " + player.healthRemaining());

		EnhancedPlayer player = new EnhancedPlayer("Deep", 50, "sword");
		System.out.println("Initial health is: " + player.getHealth());

		Printer printer = new Printer(50, true);
        System.out.println("initial page count= " + printer.getPagePrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted + " and new print count for printer was " +
                printer.getPagePrinted());

        pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted + " and new print count for printer was " +
                printer.getPagePrinted());

        System.out.println();

        Printer newPrinter = new Printer(50, false);
        System.out.println("initial page count= " + newPrinter.getPagePrinted());
        pagesPrinted = newPrinter.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted + " and new print count for printer was " +
                newPrinter.getPagePrinted());

        pagesPrinted = newPrinter.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted + " and new print count for printer was " +
                newPrinter.getPagePrinted());

    }
}
