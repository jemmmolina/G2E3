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
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

import java.io.Serializable;




public class Library implements Serializable {
	private static Map<String, List<Book>> map = new HashMap<String, List<Book>>();
	public static void main(String[] args) {
		int choice = 0;
		String[] carry = new String[4];	
		User u = new User("");
		File file = new File("books.txt");
		readFile( file, carry);
		printBooks();
		loadUser(u);
		
		while(choice!=5){
			choice = mainMenu();
			switch(choice){
				case 1:
					borrow(u);
					break;
				case 2:
					bookReturn(u);
					break;
				case 3:
					printBooks();
					break;
				case 4:
					u.printBorrowedBooks();
					break;
				case 5:
					break;
				default:
					System.out.println("Wrong input.");
					break;
			}
			saveFile(file);
		}
		serializeUser(u);			
	}
	
	private static Scanner sc = new Scanner(System.in);

	private static String welcomeUser() {
		System.out.println("\nWELCOME TO THE LIBRARY!\n");
		System.out.print("Enter your name: ");
		return sc.nextLine();
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

	private static void bookReturn(User u){
		if(u.getBookCount() == 0){
			System.out.println("You did not borrow any books.");
		}else{
			System.out.print("Enter title of book: ");
			sc.nextLine();
			String title = sc.nextLine();

			for(int i=0; i< u.getBookCount(); i++){
				if(u.getListOfBooks().get(i).getTitle().equals(title)){
					insertAtHash(u.returnBook(i));
					System.out.println("You returned " + title + " to the library.");
					break;
				}
			}
		}
	}

	private static void borrow(User u){
		System.out.print("Enter title of book: ");
		sc.nextLine();
		String title = sc.nextLine();

		if(map.containsKey(title)){
			u.borrowBook(map.get(title).get(0));
			map.get(title).remove(map.get(title).get(0));
			System.out.println("You borrowed " + title + " from the library.");

		}else{
			System.out.println("Sorry, book not available.");
		}
	}
	
	private static void loadUser(User u){
		try{
			FileInputStream file = new FileInputStream("u.ser");
			ObjectInputStream in = new ObjectInputStream(file);
			u = (User) in.readObject();
			in.close();
		}
		catch(FileNotFoundException e){
			//e.printStackTrace();
			u = new User(welcomeUser());
			serializeUser(u);
			//System.out.println("FileNotFoundException");
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Exceptionz");
		}
	}

	private static void serializeUser(User u){
		try{
			FileOutputStream file = new FileOutputStream("u.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(u);
			file.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Exceptiona");
		}
	}

	private static void readFile(File file2, String[] echos){
		try{
			int i;	
			String line;
			BufferedReader reader = new BufferedReader(new FileReader(file2));
			
		while((line = reader.readLine()) != null){
				echos = line.split(",");
				Book bago = new Book(echos[0], echos[1],echos[2], echos[3], "");
				//bago.setId();
				int randId = bago.generateId();
				Random r = new Random();
				int count = r.nextInt(6) + 15;
				for(i=0; i<count; i++) {
					// di ko magawa yung ilalagay dito :(((
					bago.setId(randId, i);
					insertAtHash(bago);
				}
			}
			reader.close();
			
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
	}
	
	private static void saveFile(File file2){
		int size;
		try{	
			BufferedWriter writer = new BufferedWriter(new FileWriter(file2, false));
			for(String key : map.keySet()){
				size = map.get(key).size();
				
				for(int i=0;i<size;i++){
					writer.write(map.get(key).get(i).getTitle()+","+map.get(key).get(i).getAuthor()+","+map.get(key).get(i).getYear()+","+map.get(key).get(i).getType()+","+map.get(key).get(i).getId());
					writer.write("\n");
				}
			}
			writer.close();
			
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
	}
	
	private static void insertAtHash(Book book){
			Book b;
			String t = book.getTitle();
			
			if(map.containsKey(t)){
				map.get(t).add(new Book(book.getTitle(), book.getAuthor(), book.getYear(), book.getType(), book.getId()));
			}else{
				List<Book> a = new ArrayList<Book>();
				map.put(t, a);
				map.get(t).add(book);
			}
	}
	
	private static void printBooks(){
		for(String key : map.keySet()){
			for(int i = 0; i<map.get(key).size(); i++){
				System.out.println("\nTitle: "+map.get(key).get(i).getTitle());
				System.out.println("Author: "+map.get(key).get(i).getAuthor());
				System.out.println("Year Published: "+map.get(key).get(i).getYear());
				System.out.println("Type: "+map.get(key).get(i).getType());			
				System.out.println("ID: "+map.get(key).get(i).getId());
			}
			System.out.println();	
		}
	}
}
