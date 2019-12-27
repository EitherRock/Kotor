package kotorCardGame;

import java.util.Random;


public class card {
	
	private int number;
	
	/**
	 * computer will generate a random number for the player.
	 * Each round will generate a new number and each new number will be added to a total
	 * @return the number which was randomly made
	 */
	public int generateNumber() {
		
		Random random = new Random();
		
		number = random.nextInt(7);
		
		while(number < 1) {
			number = random.nextInt(10);
		}
		return number;
	}
}
