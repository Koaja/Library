package main;

public class Author {

	private String authorName;

	public Author(String authorName) {
		this.authorName = authorName;
	}

	public void setName(String authorName) {
		this.authorName = authorName;
	}

	public String getName() {
		return this.authorName;
	}

	public String toString() {
		return this.authorName;
	}

}
