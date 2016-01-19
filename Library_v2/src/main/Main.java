package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {

		LibraryInteractions lib = new LibraryInteractions();
		String homeDir = System.getProperty("user.home");

		// imports existing books
		lib.importLibrary(homeDir + "//Desktop//books.txt");

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		Book book;

		String search;
		String userMenuChoice = "";
		while (true) {
			System.out.println("1. Add book");
			System.out.println("2. Edit book");
			System.out.println("3. Delete book");
			System.out.println("4. List library");
			System.out.println("5. Sort library");
			System.out.println("6. Search library");
			System.out.println("7. Export library");
			System.out.println("8. Quit");

			System.out.print("Choose your action: ");

			// add book
			try {
				userMenuChoice = bf.readLine();
				if (userMenuChoice.equals("1")) {
					System.out.print("Enter Book Author: ");
					String bookAuthor = bf.readLine();

					System.out.print("Enter Book Title: ");
					String bookTitle = bf.readLine();

					System.out.print("Enter Book Genre: ");
					String bookGenre = bf.readLine();

					// check whether any of the strings are empty then adds them
					// in the book list
					if (!bookAuthor.isEmpty() && !bookTitle.isEmpty() && !bookGenre.isEmpty()) {
						book = new Book(bookAuthor, bookTitle, bookGenre);
						lib.addBook(book);
						System.out.println("Book '" + bookAuthor + " - " + bookTitle + " - " + bookGenre
								+ "' was successfuly added in your library.\n");
					} else {
						System.out.println("Author or Title cannot be empty");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			// edit book
			if (userMenuChoice.equals("2")) {
				try {
					System.out.print("Enter Book Author: ");
					String bookAuthor = bf.readLine();

					System.out.print("Enter Book Title: ");
					String bookTitle = bf.readLine();

					System.out.print("Enter Book Genre: ");
					String bookGenre = bf.readLine();
					book = new Book(bookAuthor, bookTitle, bookGenre);

					lib.editBook(book);

					System.out.println(bookAuthor + " - " + bookTitle + " - " + bookGenre);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			// delete book
			if (userMenuChoice.equals("3")) {
				System.out.println("Which book do you wish to delete: ");
				String bookID;
				try {
					bookID = bf.readLine();
					lib.deleteBook(Integer.parseInt(bookID));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			// list library
			if (userMenuChoice.equals("4")) {
				lib.listLibrary();
				System.out.println("\nYou currently have " + lib.getNumberOfBooks() + " books in your library:");
			}

			// sort library
			if (userMenuChoice.equals("5")) {
				lib.sortLibrary();
			}

			// search library
			if (userMenuChoice.equals("6")) {
				System.out.print("Type author or book title: ");
				try {
					search = bf.readLine();
					lib.searchLibrary(search);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// export library
			if (userMenuChoice.equals("7")) {
				lib.exportLibrary(false);
			}

			// exit library
			if (userMenuChoice.equals("8")) {
				lib.exitLibrary();
			}
		}

	}
}
