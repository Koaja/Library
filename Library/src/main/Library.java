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
			for (int j = 0; j < book.length; j++) {
				if (book[j].equalsIgnoreCase(text)) {
					System.out.println(books[i]);
				} else {
					System.out.println("nothing found");
				}
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
