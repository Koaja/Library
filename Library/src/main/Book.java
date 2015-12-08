package main;

public class Book extends Author {

	private String bookTitle;

	public Book(String authorName, String bookTitle) {
		super(authorName);
		this.bookTitle = bookTitle;

	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookTitle() {
		return this.bookTitle;
	}

	public String toString() {
		return super.toString() + " - " + this.bookTitle;
	}

}
