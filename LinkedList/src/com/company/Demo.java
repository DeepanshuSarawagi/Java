package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
//        placesToVisit.add("Chennai");
//        placesToVisit.add("Bengaluru");
//        placesToVisit.add("Goa");
//        placesToVisit.add("Mumbai");
//        placesToVisit.add("Pune");
//        placesToVisit.add("Delhi");
//
//        printList(placesToVisit);
//        placesToVisit.add(5, "Jaipur");
//        printList(placesToVisit);
//        placesToVisit.remove(4);
//        printList(placesToVisit);
        addInOrder(placesToVisit, "Chennai");
        addInOrder(placesToVisit, "Bengaluru");
        addInOrder(placesToVisit, "Pune");
        addInOrder(placesToVisit, "Mumbai");
        addInOrder(placesToVisit, "Coorg");
        addInOrder(placesToVisit, "Delhi");
        printList(placesToVisit);
        addInOrder(placesToVisit, "Coimbatore");
        addInOrder(placesToVisit, "Agra");
        printList(placesToVisit);
        addInOrder(placesToVisit, "Chennai");
        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("============================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // equal, do not add
                System.out.println("new city " + newCity + " is already included as a destination" );
                return false;
            } else if (comparison > 0) {
                // the newCity should appear before this one
                // for e.g; if Agra is passed as a parameter and we are currently looking at Bengaluru then Agra should
                // be added before Bengaluru.
                stringListIterator.previous();  // we have done the comparison and we have already moved to the next
                // record in the list. Refer to line 36. .next() returned the current entry but it already moved to the
                // next entry in the list. Hence, we have to move back to the previous entry.
                stringListIterator.add(newCity);
                return true;
            } else if (comparison <0 ) {
                //move on to next city
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in your itinerary");
            return;
        } else {
            System.out.println("Now visiting: " + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Vacation over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting: " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Visiting: " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions: \nPress ");
        System.out.println("0- To quit the vacation" + "\n" +
                "1- To go to the next city" + "\n" +
                "2- To go to the previous city" + "\n" +
                "3- To print the menu options");
    }
}
