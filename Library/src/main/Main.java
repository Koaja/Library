package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
	public static void main(String[] args) throws IOException {

		Library libray = new Library();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintStream out = new PrintStream("C:\\Users\\Koaja\\Desktop\\books.txt");
		
		String line = "";
		
		while(true){
			line = bf.readLine();
			String [] array = line.split(" ");
			if(array[0].equals("add")){
                String authorName = array[1];
                String bookTitle = array [2];
                
                Book book = new Book(authorName, bookTitle);
                libray.addBook(book);
            }
			
			 if(array[0].equals("show")){
                libray.showBook();
             }
			 
			 if(array[0].equals("print")){
				 for(int i = 0 ; i < array.length ; i++){
					 out.println(array[i]);
				 }
			 }
			
		}
		
	}

}
