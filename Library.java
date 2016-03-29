package G2E3;

import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Library {
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
<<<<<<< HEAD
	
	
	public static void main(String[] args) {
		String line;
		int counter = 0;
		String[] echos;
		Book[] book = new Book[10];
		
		try{
			File file = new File("a.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			while((line = reader.readLine()) != null){
				echos = line.split(",");
				book[counter].title = echos[1];
				book[counter].author = echos[2];
				book[counter].year = echos[3];
				book[counter].id = echos[4];
				counter++;
			}
			reader.close();
			System.out.println(book[counter].title + " " + book[counter].author +" "+book[counter].year+" "+book[counter].id);
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
			//ex.printStackTrace();
			System.out.println("Exception");
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
