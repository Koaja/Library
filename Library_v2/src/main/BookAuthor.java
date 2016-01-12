package main;

public class BookAuthor {

	private String bookAuthor;

	public BookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String toString() {
		return this.bookAuthor;
	}
}
