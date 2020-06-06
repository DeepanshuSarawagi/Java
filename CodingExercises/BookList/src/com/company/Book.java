package com.company;

public class Book implements Comparable<Book>{
    private String name;
    private String AuthorName;

    public Book(String name, String authorName) {
        this.name = name;
        this.AuthorName = authorName;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    @Override
    public String toString() {
        return "Book: " + this.getName() + " written by " + this.getAuthorName() + ".";
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
    }
}
