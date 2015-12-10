package main;

import java.util.Arrays;

public class Library {

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

	public void searchBook() {
		for (int i = 0; i < this.nr; i++) {
			String ddd = Arrays.toString(books);
		}
	}

	public int getNumberOfBooks() {
		return this.nr;
	}

	public void saveToFile() {
		for (int i = 0; i < this.nr; i++) {
			System.out.println(books[i]);
		}
	}
}
