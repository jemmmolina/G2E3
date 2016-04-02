import java.util.Random;
import java.lang.Integer;
<<<<<<< HEAD
import java.io.Serializable;


public class Book implements Serializable{
=======

public class Book {
>>>>>>> a444510753a0c5f98e6291bac2665329c7f13847
	private String id;
	private String title;
	private String author;
	private String year;
	private String type;
	private char c;

	public Book( String title, String author, String year, String type, String id) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.type = type;
<<<<<<< HEAD
		this.id = id;
=======

		if(id.equals(" ")){
			Random rand = new Random();
			int randId = rand.nextInt(16)+1000;
			switch(type.charAt(0)){
				case 'T': c = 'A';break;
				case 'E': c = 'B';break;
				case 'N': c = 'C';break;
				case 'D': c = 'D';break;
			}
			String s = c + Integer.toHexString(randId).toUpperCase();	
			this.id = s;
		}else{
			this.id = id;
		}
		//this.id = id;
>>>>>>> a444510753a0c5f98e6291bac2665329c7f13847
	}


	public String getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
import java.util.Random;
import java.lang.Integer;
import java.io.Serializable;


public class Book implements Serializable{
	private String id;
	private String title;
	private String author;
	private String year;
	private String type;
	private char c;

	public Book( String title, String author, String year, String type, String id) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.type = type;
		this.id = id;
	}


	public String getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getYear() {
		return this.year;
	}

	public String getType(){
		return this.type;
	}

	
	public int generateId(){
		Random rand = new Random();
		return rand.nextInt(16)+1000;
		
	}

	public void setId(int randId, int i) {
		switch(type.charAt(0)){
			case 'T': c = 'A'; break;
			case 'E': c = 'B'; break;
			case 'N': c = 'C'; break;
			case 'D': c = 'D'; break;
		}
		String s = c + Integer.toHexString(randId + i).toUpperCase();	
		this.id = s;
	}

}	}

	public String getAuthor() {
		return this.author;
	}

	public String getYear() {
		return this.year;
	}

	public String getType(){
		return this.type;
	}

<<<<<<< HEAD
	
	public int generateId(){
		Random rand = new Random();
		return rand.nextInt(16)+1000;
		
	}

	public void setId(int randId, int i) {
		switch(type.charAt(0)){
			case 'T': c = 'A'; break;
			case 'E': c = 'B'; break;
			case 'N': c = 'C'; break;
			case 'D': c = 'D'; break;
		}
		String s = c + Integer.toHexString(randId + i).toUpperCase();	
		this.id = s;
	}

=======
>>>>>>> a444510753a0c5f98e6291bac2665329c7f13847
}