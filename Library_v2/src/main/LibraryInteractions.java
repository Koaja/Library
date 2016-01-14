package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LibraryInteractions {

	ArrayList<Book> books = new ArrayList<>();

	BufferedReader readBooksFromFile;
	PrintStream writeBooksToFile;

	File booksFile;

	public void addBook(Book b) {
		books.add(b);
	}

	public void showBooks() {
		for (Book book : books) {
			System.out.println(book);
		}
	}

	public void searchBook(String text) {
		boolean searchSuccessful = false;
		if (text.length() >= 3) {
			for (Book book : books) {
				if (book.toString().toLowerCase().contains(text)) {
					System.out.println(book);
					searchSuccessful = true;
				}
			}
		}
		if (searchSuccessful == false) {
			System.out.println("No matches were found");
		}
	}

	public int getNumberOfBooks() {
		return books.size();
	}

	public void sortBooks() {
		Collections.sort(books, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				return o1.toString().compareToIgnoreCase(o2.toString());
			}

		});
		System.out.println("Your list has been sorted!\n");
	}

	public void importBooks(String fileLocation) {
		booksFile = new File(fileLocation);
		try {
			readBooksFromFile = new BufferedReader(new InputStreamReader(new FileInputStream(booksFile)));

			String line = "";
			Book b;
			while ((line = readBooksFromFile.readLine()) != null) {
				String[] s = line.split(" - ");
				String bookAuthor = s[0];
				String bookTitle = s[1];
				String bookGenre = s[2];
				b = new Book(bookAuthor, bookTitle, bookGenre);
				this.addBook(b);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void exportBooks(boolean saveAndExit) {

		booksFile.delete();
		try {
			booksFile.createNewFile();
			writeBooksToFile = new PrintStream(booksFile);
			for (Book book : books) {
				writeBooksToFile.println(book);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (saveAndExit == true) {
			System.out.println("Library has been updated. You can safely exit the library.");
		} else {
			System.out.println("Library has been updated.");
		}

	}

	public void exitLibrary() {
		System.exit(0);
		System.out.println("Good Day!");
	}
}
