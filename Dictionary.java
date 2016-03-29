import java.util.Random;
import java.lang.Integer;

public class Dictionary extends Book {
	Random rand = new Random();
	int randId;
	String s;

	public Dictionary(String title, String author, String year) {
		super(title, author, year);
	}

	public void setId() {
		randId = rand.nextInt(16)+1000;
		s = 'D' + Integer.toHexString(randId).toUpperCase();
		this.id = s;
	}
}