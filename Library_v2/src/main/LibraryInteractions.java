package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class LibraryInteractions {

	ArrayList<Book> books = new ArrayList<>();

	BufferedReader readBooksFromFile;
	PrintStream writeBooksToFile;
	File booksFile = new File("C:\\Users\\Koaja\\Desktop\\books.txt");

	public void addBook(Book b) {
		books.add(b);
	}

	public void showBooks() {
		for (Book book : books) {
			System.out.println(book);
		}
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

		try {
			writeBooksToFile = new PrintStream(booksFile);
			readBooksFromFile = new BufferedReader(new InputStreamReader(new FileInputStream(booksFile)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (Book b : books) {
			String a = b.toString();
			try {
				if(!a.equals(readBooksFromFile.readLine())){
					writeBooksToFile.println(a);
				}else{
					System.out.println("file was already there");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
