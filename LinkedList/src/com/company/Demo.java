package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

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
}
