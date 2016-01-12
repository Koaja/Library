package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class LibraryInteractions {

	File booksLocaion;
	BufferedReader readFile;
	PrintStream writeToFile;

	Book[] books = new Book[100];
	private int nr = 0;

	public void addBook(Book b) {
		books[nr] = b;
		nr++;
	}

	public void showBook() {
		for (int i = 0; i < this.nr; i++) {
			System.out.println(books[i]);
		}
	}

	public void searchBook(String text) {
		boolean searchSuccessful = false;
		for (int i = 0; i < this.nr; i++) {
			String[] book = books[i].toString().split(" - ");
			for (int j = 0; j < book.length; j++) {
				String[] bookAndTitle = book[j].split(" ");
				for (int k = 0; k < bookAndTitle.length; k++) {
					if (bookAndTitle[k].toLowerCase().contains(text)) {
						System.out.println(books[i]);
						searchSuccessful = true;
					}
				}
			}
		}

		if (searchSuccessful == false) {
			System.out.println("No results were found!");
		}
	}

	public int getNumberOfBooks() {
		return this.nr;
	}

	public void exportLibrary() {
		booksLocaion = new File(".\\..\\booksd.txt");
		if (!booksLocaion.exists()) {
			try {
				booksLocaion.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			readFile = new BufferedReader(new InputStreamReader(new FileInputStream(booksLocaion)));
		} catch (FileNotFoundException e) {

		}
	}

	public void importLibrary() {

	}
}
