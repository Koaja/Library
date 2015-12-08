package main;

public class Library {

	Book[] books = new Book[100];
	int nr = 0;

	public void addBook(Book b) {
		books[nr] = b;
		nr++;
	}

	public void showBook() {
		for (int i = 0; i < this.nr; i++) {
			System.out.println(books[i]);
		}
	}

	public void sortByAuthorName(String authorName) {
		for (int i = 0; i < this.nr; i++) {

			if (authorName.equals(books[1])) {
				System.out.println(books[1]);
			}
		}
	}
	
	public void saveToFile(){
		for (int i = 0; i < this.nr; i++) {
			System.out.println(books[i]);
		}
	}
}
