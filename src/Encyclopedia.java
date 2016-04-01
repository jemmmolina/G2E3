
import java.util.Random;
import java.lang.Integer;

public class Encyclopedia extends Book {
	Random rand = new Random();
	int randId;
	String s;

	public Encyclopedia(String title, String author, String year) {
		super(title, author, year);
	}	

	public void setId() {
		randId = rand.nextInt(16)+1000;
		s = 'C' + Integer.toHexString(randId).toUpperCase();
		this.id = s;
	}
}