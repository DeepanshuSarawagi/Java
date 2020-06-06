package com.company;

import java.util.LinkedList;
import java.util.List;

public class BookShelf {
    private final String name;
    private List<String> wantToRead = new LinkedList<>();

    public BookShelf(String name) {
        this.name = name;
    }

    protected void booksWantToRead(String name) {
        String bookToBeRead = "";
        for (String book: Main.bookList.items().keySet()) {
            if (book.equals(name)) {
                bookToBeRead = name;
                System.out.println(bookToBeRead);
            }
        }
        if (wantToRead.contains(bookToBeRead)) {
            System.out.println("Sorry! This book is already in the list");
        } else {
            wantToRead.add(bookToBeRead);
        }
        System.out.println("Your updated to be read book list is:");
        for (String s : wantToRead) {
            System.out.println(s);
        }
    }
}
