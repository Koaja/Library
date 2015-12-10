package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {

		Library library = new Library();
		Book book;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] line = null;
		String search;
		String userMenuChoice = "";

		while (true) {
			System.out.println("1. Add book");
			System.out.println("2. Search");
			System.out.println("3. List");
			System.out.println("4. Quit");

			System.out.print("Choose your action: ");
			userMenuChoice = bf.readLine();
			if (userMenuChoice.equals("1")) {
				System.out.println("Enter Author");
				String author = bf.readLine();

				System.out.println("Enter Book Title");
				String bookTitle = bf.readLine();

				book = new Book(author, bookTitle);
				library.addBook(book);

				System.out.println("Book " + author + " - " + bookTitle + " was successfuly added");
			}
			if (userMenuChoice.equals("2")) {
				System.out.println("Type author or book title");
				search = bf.readLine();
				library.searchBook();
			}

			if (userMenuChoice.equals("3")) {
				System.out.println("You currently have " + library.getNumberOfBooks() + " books in your library:");
				library.showBook();
			}

			if (userMenuChoice.equals("4")) {
				System.exit(0);
			}
		}
	}
}