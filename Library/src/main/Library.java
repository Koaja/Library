package main;

public class Library {

	Book[] books = new Book[100];
	private int nr = 0;

	public void addBook(Book b) {
		books[nr] = b;
		nr++;
	}

	public void showBook() {
		for (int i = 0; i < this.nr; i++) {
			System.out.println(books[i]);
		}
	}

	public void searchBook(String text) {
		for (int i = 0; i < this.nr; i++) {
			String[] book = books[i].toString().split(" ");
			if (book[i].equals(text)) {
				System.out.println(books[i]);
			}
		}
	}

	public int getNumberOfBooks() {
		return this.nr;
	}

	public void saveToFile() {
		for (int i = 0; i < this.nr; i++) {
			System.out.println(i + "." + " " + books[i]);
		}

	}
}
