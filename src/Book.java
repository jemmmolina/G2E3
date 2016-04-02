import java.util.Random;
import java.lang.Integer;

public class Book {
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
	}

	//public void setId();

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

}