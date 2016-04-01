//package G2E3;

import java.util.Random;
import java.lang.Integer;

public class Textbook extends Book {
	Random rand = new Random();
	int randId;
	String s;

	public Textbook(String title, String author, String year) {
		super(title, author, year);
	}	

	public void setId() {
		randId = rand.nextInt(16)+1000;
		s = 'A' + Integer.toHexString(randId).toUpperCase();
		this.id = s;
	}
}