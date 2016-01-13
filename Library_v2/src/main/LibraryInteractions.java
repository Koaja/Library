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
	File booksFile = new File("C:\\Users\\Balea Cristian\\Downloads\\books.txt");

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
		for (Book book : books) {
			if (book.toString().contains(text)) {
				System.out.println(book);
				searchSuccessful = true;
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
	}

	public void importBooks() {
		try {
			readBooksFromFile = new BufferedReader(new InputStreamReader(new FileInputStream(booksFile)));
			if (!booksFile.exists()) {
				booksFile.createNewFile();
			} else {
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
			}

		} catch (IOException e) {
			try {
				booksFile.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

	public void exportBooks() {

		booksFile.delete();
		try {
			booksFile.createNewFile();
			writeBooksToFile = new PrintStream(booksFile);
			for (Book book : books) {
				writeBooksToFile.println(book);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
