import java.util.Scanner;
import java.util.Random;


public class Library {
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	final static int limit = 1000;
	
	public static void main(String[] args) {
		String username;
		Book[] borrowedBooks;
		Book[] libraryBooks = new Book[limit];

		int choice;
		username = welcomeUser();


		do {
			choice = mainMenu();
	
			switch(choice) {
				case 1:
					break;

				case 2:
					break;

				case 3:
					break;

				case 4: 
					break;

				case 5:
					System.out.println("");
					System.out.println("Goodbye.");
					break;

				default:
					System.out.println("");
					System.out.println("Invalid input.");
					break;
			}
		} while (choice != 5);
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
