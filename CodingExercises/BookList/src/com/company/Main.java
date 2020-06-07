package com.company;

import java.util.Scanner;

public class Main {
    protected static BookList bookList = new BookList();
    private static BookShelf bookShelf;
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
//		bookList.sortedBooks();
		System.out.println("=============================");
		yourBookShelf();
    }

    public static void yourBookShelf() {
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		printOptions();
		System.out.println("Please enter appropriate option from menu: ");
		while (!quit) {
			int action = scanner.nextInt();
			scanner.nextLine();
			switch (action) {
				case 0:
					System.out.println("Exiting from this application");
					quit=true;
					break;
				case 1:
					System.out.println("Please enter your name: ");
					String name = scanner.nextLine();
					System.out.println("Creating book shelf of " + name);
					String bookShelfName = name + "`s shelf";
					bookShelf = new BookShelf(bookShelfName);
					System.out.println(bookShelf.getName() + " created.");
					break;
				case 2:
					System.out.println("Printing books from our database.");
					bookList.sortedBooks();
					break;
				case 3:
					System.out.println("Please enter a book name of your choice to add in the want to read list: ");
					String wantToRead = scanner.nextLine();
					System.out.println("you have chosen to add " + wantToRead);
					bookShelf.booksWantToRead(wantToRead);
					break;
				case 4:
					System.out.println("Please enter a book name to add in the currently reading list: ");
					String currentlyReading = scanner.nextLine();
					System.out.println("you have chosen to add " + currentlyReading);
					bookShelf.booksCurrentlyReading(currentlyReading);
					break;
				case 5:
					System.out.println("Please enter a book name to add in the finished reading list: ");
					String finishedReading = scanner.nextLine();
					System.out.println("you have chosen to add " + finishedReading);
					bookShelf.booksFinishedReading(finishedReading);
					break;
				case 6:
					System.out.println("Viewing your book shelf");
					bookShelf.yourBookShelf();
					break;
				case 7:
					System.out.println("Resetting your currently reading progress");
					bookShelf.reviewProgress();
					break;
				case 8:
					printOptions();
					break;
			}
		}
	}
	private static void printOptions() {
		System.out.println("0 - To quit from the application " + "\n" +
						   "1 - To create your book shelf " + "\n" +
						   "2 - To print books from our database " + "\n" +
						   "3 - To add a book in WantToRead list " + "\n" +
						   "4 - To add a book in CurrentlyReading list " + "\n" +
						   "5 - To add a book in FinishedReading list " + "\n" +
						   "6 - To view your book shelf " + "\n" +
						   "7 - To reset your currently reading progress" + "\n" +
						   "8 - To print this option menu again");
	}

}