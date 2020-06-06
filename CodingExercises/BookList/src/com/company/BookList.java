package com.company;

import java.util.*;

public class BookList {
    private Map<String, Book> list;
    private List<Book> BookList = new ArrayList<>();

    public BookList() {
        this.list = new LinkedHashMap<>();
    }

    public Map<String, Book> items() {
        return Collections.unmodifiableMap(list);
    }

    public void addBooks(Book book) {
        Book bookInList = list.get(book.getName());
        if (bookInList == null) {
            list.put(book.getName(), book);
//            System.out.println("Book successfully added in the list");
        } else {
            System.out.println("Book is already in the list");
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nBook List\n");
        for (Map.Entry<String, Book> bookEntry:list.entrySet()) {
            Book book = bookEntry.getValue();
            s.append(book).append("\n");
        }
        return s.toString();
    }

    public void sortedBooks() {
        for (Map.Entry<String, Book> bookList:list.entrySet()) {
            Book book = bookList.getValue();
            BookList.add(book);
        }
        Collections.sort(BookList);
        for (Book book : BookList) {
            System.out.println(book);
        }
    }
}
