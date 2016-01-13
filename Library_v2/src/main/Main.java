package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {

		LibraryInteractions lib = new LibraryInteractions();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Book book;

		String[] line = null;
		String search;
		String userMenuChoice = "";
		while (true) {
			System.out.println("1. Add book");
			System.out.println("2. Search");
			System.out.println("3. List");
			System.out.println("4. Export libray");
			System.out.println("5. Import library");
			System.out.println("6. Quit");

			System.out.print("Choose your action: ");
			try {
				userMenuChoice = bf.readLine();
				if (userMenuChoice.equals("1")) {
					System.out.print("Enter Book Author: ");
					String bookAuthor = bf.readLine();

					System.out.print("Enter Book Title: ");
					String bookTitle = bf.readLine();

					System.out.print("Enter Book Genre: ");
					String bookGenre = bf.readLine();

					if (!bookAuthor.isEmpty() && !bookTitle.isEmpty()) {
						book = new Book(bookAuthor, bookTitle, bookGenre);
						lib.addBook(book);
						System.out.println(
								"Book " + bookAuthor + " - " + bookTitle + " was successfuly added in your library.\n");
					} else {
						System.out.println("Author or Title cannot be empty");
					}

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (userMenuChoice.equals("2")) {
				System.out.print("Type author or book title: ");
				try {
					search = bf.readLine();
					lib.searchBook(search);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			if (userMenuChoice.equals("3")) {
				lib.showBooks();

				System.out.println();
				System.out.println("You currently have " + lib.getNumberOfBooks() + " books in your library:");
			}

			if (userMenuChoice.equals("4")) {
				lib.exportBooks();
			}

			if (userMenuChoice.equals("5")) {
				lib.importBooks();
			}

			if (userMenuChoice.equals("6")) {
				lib.sortBooks();
			}
		}

	}
}
