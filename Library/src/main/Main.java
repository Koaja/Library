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
		// PrintStream out = new PrintStream("C:\\Users\\Balea
		// Cristian\\Desktop\\books3.txt");

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
			userMenuChoice = bf.readLine();
			if (userMenuChoice.equals("1")) {
				System.out.println("Enter Author");
				String author = bf.readLine();

				System.out.println("Enter Book Title");
				String bookTitle = bf.readLine();

				if (!author.isEmpty() && !bookTitle.isEmpty()) {
					book = new Book(author, bookTitle);
					library.addBook(book);
					System.out.println(
							"Book " + author + " - " + bookTitle + " was successfuly added in your library.\n");
				} else {
					System.out.println("Author or Title cannot be empty");
				}

			}
			if (userMenuChoice.equals("2")) {
				System.out.println("Type author or book title");
				search = bf.readLine();
				library.searchBook(search);
			}

			if (userMenuChoice.equals("3")) {
				library.showBook();

				System.out.println();
				System.out.println("You currently have " + library.getNumberOfBooks() + " books in your library:");
			}

			if (userMenuChoice.equals("4")) {
				// export library code
			}

			if (userMenuChoice.endsWith("5")) {
				// import library code
			}

			if (userMenuChoice.equals("6")) {
				System.exit(0);
			}
		}
	}
}
