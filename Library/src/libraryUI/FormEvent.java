package libraryUI;

import java.util.EventObject;

public class FormEvent extends EventObject {

	private String bookTitle;
	private String bookAuthor;

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String bookTitle, String bookAuthor) {
		super(source);
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

}
