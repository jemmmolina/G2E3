package G2E3;

public class Book {
<<<<<<< HEAD
	String id = "";
	String title = "";
	String author = "";
	String year = "";

	public Book( String title, String author, String year) {
=======
	protected String id;
	private String title;
	private String author;
	private String year;

	public Book(String title, String author, String year) {
>>>>>>> 7bc9389c41d274bcf3a2e981e87b44da1d360336
		this.title = title;
		this.author = author;
		this.year = year;
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