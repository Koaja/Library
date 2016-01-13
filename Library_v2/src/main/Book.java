package main;

public class Book extends BookGenre {

	public Book(String bookAuthor, String bookTitle, String bookGenre) {
		super(bookAuthor, bookTitle, bookGenre.toUpperCase());

	}

}
