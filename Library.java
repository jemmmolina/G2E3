import java.util.Scanner;
import java.util.Random;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Library {
	private static Map<String, List<Book>> map = new HashMap<String, List<Book>>();
	public static void main(String[] args) {
		int counter = 0;
		String[] carry = new String[4];
		
			File file = new File("books.txt");
			
			readFile( file, carry);
			
			for(String key : map.keySet()){
				System.out.println(key);
			}
			
	}
	
	private static Scanner sc = new Scanner(System.in);
	
	private static void readFile(File file2, String[] echos){
		try{	
			String line;
			BufferedWriter writer = new BufferedWriter(new FileWriter(file2, true));
			BufferedReader reader = new BufferedReader(new FileReader(file2));
			
			while((line = reader.readLine()) != null){
				echos = line.split(",");
				Book bago = new Book(echos[0],echos[1],echos[2]);
				insertAtHash(bago);
			}
			reader.close();
			//writer.close();
			
			}
		catch(FileNotFoundException e){
			//e.printStackTrace();
			System.out.println("FileNotFoundException");
		}
		catch(IOException ex){
			//ex.printStackTrace();
			System.out.println("IOException");
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Exception");
		}
		finally{
			//printBooks(book,counter);
		}
	}
	
	private static void insertAtHash(Book book){
			Book b;
			String t = book.title;
			
			if(map.containsKey(t)){
				map.get(t).add(new Book(book.title,book.author,book.year));
			}else{
				List<Book> a = new ArrayList<Book>();
				map.put(t, a);
				map.get(t).add(new Book(book.title,book.author,book.year));
			}
	}
	
	private static void printBooks(Book[] book, int counter){
		for(int i = 0; i<counter; i++){
			System.out.println("Title: "+book[i].title);
			System.out.println("Author: "+book[i].author);
			System.out.println("Year Published: "+book[i].year);
			System.out.println("ID: "+book[i].id);
			System.out.println();			
		}
	}
	
	private static int mainMenu() {
		System.out.println("");
		System.out.println("\tM E N U");
		System.out.println("[1] Borrow a book");
		System.out.println("[2] Return a book");
		System.out.println("[3] View books in the library");
		System.out.println("[4] View borrowed books");
		System.out.println("[5] Exit");
		System.out.print("Enter choice: ");
		return sc.nextInt();
	}

	private static String welcomeUser() {
		System.out.println("");
		System.out.println("WELCOME TO THE LIBRARY!");
		System.out.println("");
		System.out.print("Enter your name: ");
		return sc.nextLine();
	}
}
