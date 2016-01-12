package main;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		LibraryInteractions lib = new LibraryInteractions();

		lib.importBooks();
		Book b = new Book("dsadsa", "dsadsa", "dsadas"); 
		lib.addBook(b);
		lib.showBooks();
		System.out.println();
		System.out.println();
		lib.exportBooks();
	}
}
