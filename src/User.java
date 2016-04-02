import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	private String name;
	private ArrayList<Book> borrowedBooks = new ArrayList<Book>();

	public User(String name){
		this.name = name;
	}	

	public void borrowBook(Book book){
		this.borrowedBooks.add(book);
	}

	public Book returnBook(int book){ 
		Book b = borrowedBooks.get(book);
		borrowedBooks.remove(book);
		return b;
	}

	public void printBorrowedBooks(){
		if(borrowedBooks.size() == 0){
			System.out.println("You did not borrow any books.");
		}else{
			System.out.println("===== Borrowed Books =====");
			for(int i=0; i < borrowedBooks.size() ; i++){
				System.out.println("> " + borrowedBooks.get(i).getTitle());
			}
			System.out.println("==========================");			
		}
	}

	public String getName(){
		return this.name;
	}

	public ArrayList<Book> getListOfBooks(){
		return this.borrowedBooks;
	}

	public int getBookCount(){
		return this.borrowedBooks.size();
	}
}