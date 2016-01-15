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

	BufferedReader readBooksFromFile;
	BufferedReader input;
	PrintStream writeBooksToFile;
	File booksFile;

	public void addBookToLibrary(Book b) {
		booksCollections.add(b);
	}

	public void showBooksPresentInLibrary() {
		for (Book book : booksCollections) {
			System.out.println(book);
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

	public int getNumberOfBooks() {
		return booksCollections.size();
	}

	public void sortBooks() {
		Collections.sort(booksCollections, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				return o1.toString().compareToIgnoreCase(o2.toString());
			}

		});
		System.out.println("/nYour list has been sorted!\n");
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
				addBookToLibrary(b);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

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

	public void exitLibrary(String userChoice) {
		input = new BufferedReader(new InputStreamReader(System.in));
		if (isLibraryUpToDate()) {
			System.out.println("Your library is up-to-date. Have a good day!");
			System.exit(0);
		} else {
			System.out.println("Your Library is not up-to-date. Would you like to update it now ?");
			try {
				userChoice = input.readLine();
				if (userChoice.toLowerCase().equals("yes")) {
					saveLibrary(true);
				} else if (userChoice.toLowerCase().equals("no")) {
					System.out.println("Your library was not updated.");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
