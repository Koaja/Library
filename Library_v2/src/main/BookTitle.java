package main;

public class BookTitle extends BookAuthor {

	private String bookTitle;

	public BookTitle(String bookAuthor, String bookTitle) {
		super(bookAuthor);
		this.bookTitle = bookTitle;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String toString() {
		return super.toString() + " - " + this.bookTitle;
	}
}
