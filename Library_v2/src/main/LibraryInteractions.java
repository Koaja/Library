package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LibraryInteractions {

	ArrayList<Book> booksCollections = new ArrayList<>();

	private BufferedReader readBooksFromFile;
	private BufferedReader input;
	private PrintStream writeBooksToFile;
	private File booksFile;

	/**
	 * 
	 * @param b
	 *            adds a new book in library in the format
	 *            "Author - Title - GENRE"
	 */
	public void addBookToLibrary(Book b) {
		booksCollections.add(b);
	}

	/**
	 * Lists all books present in library
	 */
	public void showBooksPresentInLibrary() {
		int index = 1;
		for (Book book : booksCollections) {
			System.out.println(index + ". " + book);
			index++;
		}
	}

	/**
	 * 
	 * @param searchString
	 *            string to be searched for in array
	 */
	public void searchLibrary(String searchString) {
		boolean searchSuccessful = false;
		if (searchString.length() >= 3) {
			for (Book book : booksCollections) {
				if (book.toString().toLowerCase().contains(searchString)) {
					System.out.println(book);
					searchSuccessful = true;
				}
			}
		}

		if (searchSuccessful == false) {
			System.out.println("No matches were found");
		}
	}

	/**
	 * 
	 * @return number of books
	 */
	public int getNumberOfBooks() {
		return booksCollections.size();
	}

	/**
	 * Sorts the books alphabetically
	 */

	public void sortBooks() {
		Collections.sort(booksCollections, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				return o1.toString().compareToIgnoreCase(o2.toString());
			}

		});
		System.out.println("\nYour list has been sorted!\n");
	}

	/**
	 * 
	 * @param fileLocation
	 *            - local user director from which the import is made
	 */

	public void importBooks(String fileLocation) {
		booksFile = new File(fileLocation);

		if (!booksFile.exists()) {
			try {
				System.out.println("\nNo local library was found, so we created one instead.\n");
				booksFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

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
				addBookToLibrary(b);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param saveAndExit
	 *            different message is displayed depending on boolean value
	 */
	public void saveLibrary(boolean saveAndExit) {

		booksFile.delete();
		try {
			booksFile.createNewFile();
			writeBooksToFile = new PrintStream(booksFile);
			for (Book book : booksCollections) {
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

	/**
	 * 
	 * @param b
	 *            - adds a book at an index decided by the user
	 */
	public void editBook(Book b) {
		Book parsedBookID = null;
		System.out.println("Get book id: ");
		input = new BufferedReader(new InputStreamReader(System.in));
		try {
			String bookID = input.readLine();
			parsedBookID = booksCollections.get(Integer.parseInt(bookID));
			booksCollections.set(1 - Integer.parseInt(bookID), b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(parsedBookID.toString() + " has been replaced with : ");
	}

	public void deleteBook(int bookID) {
		booksCollections.remove(bookID);
	}

	/**
	 * 
	 * @return boolean - if the number of lines in file is equal to the size of
	 *         the list
	 */

	public boolean isLibraryUpToDate() {

		int amountOfBooksInCollection = booksCollections.size();
		int amountOfBooksInFile = 0;
		try {
			readBooksFromFile = new BufferedReader(new InputStreamReader(new FileInputStream(booksFile)));
			while (readBooksFromFile.readLine() != null) {
				amountOfBooksInFile++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return amountOfBooksInCollection == amountOfBooksInFile;
	}

	/**
	 * 
	 * @param userChoice
	 *            - input from user deciding if user wants to update library
	 */
	public void exitLibrary(String userChoice) {
		input = new BufferedReader(new InputStreamReader(System.in));
		if (isLibraryUpToDate()) {
			System.out.println("Your library is up-to-date. Have a good day!");
			System.exit(0);
		} else {
			System.out.println("Your Library is not up-to-date. Would you like to update it now ?[yes/no]");
			try {
				userChoice = input.readLine();
				if (userChoice.toLowerCase().equals("yes")) {
					saveLibrary(true);
				} else if (userChoice.toLowerCase().equals("no")) {
					System.out.println("Your library was not updated. Have a good day!");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
