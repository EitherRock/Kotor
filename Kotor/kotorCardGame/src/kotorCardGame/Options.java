package kotorCardGame;

import java.util.LinkedList;

public class Options {
	
	private String[] options = new String[3];
	
	/**
	 * Adds these strings to the options array.
	 * 
	 */
	public void setUpDisplay() {
	options[0] = "End Turn";
	options[1] = "Stand";
	options[2] = "Use Card";
	}
	
	public void displayOptions() {
		
		for(int index = 0; index < options.length; index++) {
			System.out.printf("%d %s\n", index + 1,options[index]);
		}
	}
	
	
	public void displayUseHand(LinkedList<Integer> hand) {
		
		for(int index = 0; index < hand.size();index++) {
			System.out.printf("%d %d\n",index + 1, hand.get(index));
		}
		
	}
	
	public void displayBack() {
		System.out.println("0 back");
	}
	
	public int cardChoice(int index, LinkedList<Integer> hand) {
		return hand.get(index);
		}
	
	
	public void RemoveCard(int index, LinkedList<Integer> playerHand) {
		
		playerHand.remove(index);
	}
}
