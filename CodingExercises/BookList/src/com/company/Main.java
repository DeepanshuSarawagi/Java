package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {
    protected static BookList bookList = new BookList();
    private static List<String> wantToRead = new LinkedList<>();
    public static void main(String[] args) {
	    Book book = new Book("The Immortals of Meluha", "Amish Tripathi");
	    bookList.addBooks(book);
	    book = new Book("The Secret of Nagas", "Amish Tripathi");
	    bookList.addBooks(book);
		book = new Book("The Oath of Vayuputra", "Amish Tripathi");
		bookList.addBooks(book);
		book = new Book("The Oath of Vayuputra", "Amish Tripathi");
		bookList.addBooks(book);
		book = new Book("The Vault of Vishnu", "Ashwin Sanghi");
		bookList.addBooks(book);
		book = new Book("The Krishna Key", "Ashwin Sanghi");
		bookList.addBooks(book);
		book = new Book("Chanakya`s Chant", "Ashwin Sanghi");
		bookList.addBooks(book);
		book = new Book("Keepers of the Kalachakra", "Ashwin Sanghi");
		bookList.addBooks(book);
		book = new Book("Harry Potter and the Philosopher`s Stone", "J.K.Rowling");
		bookList.addBooks(book);
		book = new Book("Harry Potter and the Chambers of secret", "J.K.Rowling");
		bookList.addBooks(book);
		book = new Book("Harry Potter and the Prisoner of Azkaban", "J.K.Rowling");
		bookList.addBooks(book);
		book = new Book("Harry Potter and the Goblet of Fire", "J.K.Rowling");
		bookList.addBooks(book);
		book = new Book("Harry Potter and the Order of the Phoenix", "J.K.Rowling");
		bookList.addBooks(book);
		book = new Book("Harry Potter and the Half-Blood Prince", "J.K.Rowling");
		bookList.addBooks(book);
		book = new Book("Harry Potter and the Deathly Hollows", "J.K.Rowling");
		bookList.addBooks(book);
		book = new Book("Gun Island", "Amitav Ghosh");
		bookList.addBooks(book);
		bookList.sortedBooks();
		System.out.println("=============================");
		BookShelf deepsBookShelf = new BookShelf("Deeps Book Shelf");
		deepsBookShelf.booksWantToRead("Gun Island");
		deepsBookShelf.booksWantToRead("Harry Potter and the Deathly Hollows");

    }

}