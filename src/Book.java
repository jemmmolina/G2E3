//package G2E3;

public class Book {
	String id = "";
	String title = "";
	String author = "";
	String year = "";

	public Book( String title, String author, String year) {
		this.title = title;
		this.author = author;
		this.year = year;
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

}