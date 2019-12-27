package kotorCardGame;

import java.util.LinkedList;
import java.util.Random;

public class PlayerHand {
	
	private LinkedList<Integer> hand = new LinkedList<>();
	Random random = new Random();
	
	/**
	 * generates a player hand with 5 cards
	 */
	public void fillHand() {
		
		for(int size = 0; size < 5; size++) {
			this.hand.add(makeNegative(randomNumber()));
		}
	}
	
	
	/**
	 * get random int
	 * @return randomized int
	 */
	private int randomNumber() {
		
		int number;
		
		number = random.nextInt(7);
		
		while(number < 1) {
			number = random.nextInt(10);
		}
		
		return number;
	}
	
	/**
	 * takes a number and randomly makes it negative
	 * @param num randomized int from randomNmber()
	 * @return the final randomized number, negative or positive
	 */
	private int makeNegative(int num) {
		
		boolean bool = random.nextBoolean();
		
		if(bool) {
			return num * (-1);
		}
		
		return num;
	}
	
	//public void setHand(LinkedList<Integer> hand) {
	//	this.hand = hand;
	//}
	
	public LinkedList<Integer> getHand() {
		
		return hand;
	}
	
	public void displayHand() {
		for(int index = 0; index < hand.size(); index++) {
			System.out.print(this.hand.get(index));
			System.out.print(" ");
		}
		System.out.println("");
	}
	
	public void mainDisplay(String name,int total, StringBuilder string) {
		//Options options = new Options();
		System.out.printf("%s    total: %d\n",name, total);
		//System.out.printf("Turn = %d\n", turn);
		System.out.println(string);
		System.out.println("");
		System.out.println("Player Hand:");
		displayHand();
		System.out.println("");
		System.out.println("Options:");
		//options.displayOptions();
	}
}
