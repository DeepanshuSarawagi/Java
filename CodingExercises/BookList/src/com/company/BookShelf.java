package com.company;

import java.util.LinkedList;
import java.util.List;

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
        String bookToBeRead = "";
        for (String book: Main.bookList.items().keySet()) {
            if (book.equals(name)) {
                bookToBeRead = name;
//                System.out.println(bookToBeRead);
                break;
            }
        }
        if (this.wantToRead.contains(bookToBeRead)) {
            System.out.println("Sorry! This book is already in the list");
        } else {
            this.wantToRead.add(bookToBeRead);
        }
    }

    protected void booksCurrentlyReading(String name) {
        String bookCurrentlyReading = "";
        for (String book: this.wantToRead) {
            if (book.equals(name)) {
                bookCurrentlyReading = name;
//                System.out.println(bookCurrentlyReading);
                break;
            }
        }
        if (this.currentlyReading.contains(bookCurrentlyReading)) {
            System.out.println("You are already reading this book");
        } else {
            this.currentlyReading.add(bookCurrentlyReading);
            this.wantToRead.remove(bookCurrentlyReading);
        }
    }

    protected void booksFinishedReading(String name) {
        String bookFinishedReading = "";
        for (String book: this.currentlyReading) {
            if (book.equals(name)) {
                bookFinishedReading = name;
//                System.out.println(bookFinishedReading);
                break;
            }
        }
        if (this.finishedReading.contains(bookFinishedReading)) {
            System.out.println("You are already finished this book");
        } else {
            this.finishedReading.add(bookFinishedReading);
            this.currentlyReading.remove(bookFinishedReading);
        }
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
        if (this.currentlyReading.size() ==0) {
            System.out.println(NO_BOOKS);
        } else {
            System.out.println("Currently reading book list:");
            for (String s : this.currentlyReading) {
                System.out.println(s);
            }
        }

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
