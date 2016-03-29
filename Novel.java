import java.util.Random;
import java.lang.Integer;

public class Novel extends Book {
	Random rand = new Random();
	int randId;
	String s;

	public Novel(String title, String author, String year) {
		super(title, author, year);
	}

	public void setId() {
		randId = rand.nextInt(16)+1000;
		s = 'B' + Integer.toHexString(randId).toUpperCase();
		this.id = s;
	}
}