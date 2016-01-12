package main;

public class BookGenre extends BookTitle {

	private String bookGenre;

	public BookGenre(String bookAuthor, String bookTitle, String bookGenre) {
		super(bookAuthor, bookTitle);
		this.bookGenre = bookGenre;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String toString() {
		return super.toString() + " - " + this.bookGenre;
	}

}
