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
		boolean searchSuccessful = false;
		for (int i = 0; i < this.nr; i++) {
			String[] book = books[i].toString().split(" - ");
			for (int j = 0; j < book.length; j++) {
				String[] words = book[j].split(" ");
				if (words[j].toLowerCase().equals(text)) {
					System.out.println(books[i]);
					searchSuccessful = true;
				}
			}
		}

		if (searchSuccessful == false) {
			System.out.println("No results were found!");
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

/*
 * String string = "Ana are doice - multe sada mere"; String mere = "multe mere"
 * ; String mere2 = "are"; String[] titlu = string.split(" - ");
 * 
 * for (int i = 0; i < titlu.length; i++) { String b = titlu[i]; if
 * (b.contains(mere)) { System.out.println("yo"); } // System.out.println(b);
 * for (int j = 0; j < titlu.length; j++) { String[] a = b.split(" "); if
 * (a[j].equals(mere2)) { System.out.println("are ma"); } } }
 * 
 * }
 */