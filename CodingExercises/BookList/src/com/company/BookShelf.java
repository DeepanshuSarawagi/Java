package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class BookShelf {
    private final String name;
    private List<String> wantToRead = new LinkedList<>();
    private List<String> currentlyReading = new LinkedList<>();
    private List<String> finishedReading = new LinkedList<>();

    public BookShelf(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getCurrentlyReading() {
        return currentlyReading;
    }

    protected void booksWantToRead(String name) {
        if (Main.bookList.items().containsKey(name)) {
            if (this.wantToRead.contains(name)) {
                System.out.println("Sorry! This book is already in the list");
//                System.out.println(bookToBeRead);
        }  else {
            this.wantToRead.add(name);
        }
        } else {
            System.out.println("Book " + name + " not found in our database");
        }
    }

    protected void booksCurrentlyReading(String name) {
        if (Main.bookList.items().containsKey(name)) {
            if (this.currentlyReading.contains(name)) {
                System.out.println("Sorry! You are already reading " + name);
            } else {
                this.currentlyReading.add(name);
                this.wantToRead.remove(name);
            }
        } else {
            System.out.println("Book " + name + " not found in our database");
        }
    }

    protected void booksFinishedReading(String name) {
        if (Main.bookList.items().containsKey(name)) {
            if (this.finishedReading.contains(name)) {
                System.out.println("Sorry! You finished reading " + name);
            } else {
                this.finishedReading.add(name);
                this.wantToRead.remove(name);
                this.currentlyReading.remove(name);
            }
        } else {
            System.out.println("Book " + name + " not found in our database");
        }
    }

    protected void reviewProgress() {
        ListIterator<String> listIterator = this.currentlyReading.listIterator();
        boolean forward = true;
        boolean quit = false;
        printOptions();
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            System.out.println("Enter a number of your choice: ");
            int action = scanner.nextInt();
            switch (action){
                case 0:
                    System.out.println("Exiting from the list");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now reading " + listIterator.next());
                    } else {
                        System.out.println("We have reached the end of the list");
                        forward=false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now reading " + listIterator.previous());
                    } else {
                        System.out.println("We have reached at the start of the list");
                        forward=true;
                    }
                    break;
                case 3:
                    printOptions();
                    break;
            }
        }


    }

    private void printOptions() {
        System.out.println("0 - To exit from the currently reading list " + "\n" +
                           "1 - To move to the next currently reading book " + "\n" +
                           "2 - To move to the previous currently reading book " + "\n" +
                           "3 - To print this option menu again");
    }

    protected void yourBookShelf() {
        final String NO_BOOKS = "You do not have any books in this list.";
        System.out.println("To be read book list:");
        if (this.wantToRead.size()==0) {
            System.out.println(NO_BOOKS);
        } else {
            for (String s : this.wantToRead) {
                System.out.println(s);
            }
        }
        System.out.println("Currently reading book list:");
        if (this.currentlyReading.size() ==0) {
            System.out.println(NO_BOOKS);
        } else {
            System.out.println("Currently reading book list:");
            for (String s : this.currentlyReading) {
                System.out.println(s);
            }
        }
        System.out.println("Finished reading book list:");
        if (this.finishedReading.size() ==0) {
            System.out.println(NO_BOOKS);
        } else {
            System.out.println("Finished reading book list:");
            for (String s : this.finishedReading) {
                System.out.println(s);
            }
        }
    }
}
