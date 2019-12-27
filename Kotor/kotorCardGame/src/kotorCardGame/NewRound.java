package kotorCardGame;

public class NewRound {

	
	public boolean p1Stand;
	public boolean p2Stand;
	public int p1Total;
	public int p2Total;
	public StringBuilder str1 = new StringBuilder();
	public StringBuilder str2 = new StringBuilder();
	

	/**
	 * Resets all the variables to start a new round
	 */
	public void createNewRound() {
		
		this.p1Stand = false;
		this.p2Stand = false;
		this.p1Total = 0;
		this.p2Total = 0;
		this.str1.setLength(0);
		this.str2.setLength(0);
		
	}
	
	/**
	 * Will check if either player reached the target number without being a tie
	 * @param max target number to hit
	 * @return who won 1: player1 2: player2
	 */
	public int checkRound(int max) {
		
		int whoWon = 0;
		
		if(this.p1Total <= max && this.p2Total > max) {
			whoWon = 1;
		}
		else if(this.p2Total <= max && this.p1Total > max) {
			whoWon = 2;
		}
		
		if(this.p1Total == max && this.p2Total != max  ) {
			whoWon = 1;
		}else if (this.p2Total == max && this.p1Total != max) {
			whoWon = 2;
		}
		
		return whoWon;
	
	}
	
	/**
	 * compares player scores to see if a game was tied
	 * @param max number to reach in game. Usually 20
	 * @return true is game is a tie; false if not tied.
	 */
	public boolean isGameTied(int max) {
		if(this.p1Total == max && max == this.p2Total) {
			return true;
		}
		else if(this.p1Total > max && this.p2Total > max) {
			return true;
		}
		return false;
	}
	
	/**
	 * When a stand happens with both players, the game checks the difference from the max number. 
	 * Whichever player is closer to the max number wins the round.
	 * @param max number to reach in game; Usually 20.
	 * @return the number associated with who won
	 */
	public int totalDifference(int max) {
		int finalTotal1 = max - p1Total;
		int finalTotal2 = max - p2Total;
		int whoWon = 0; // 1: player1     2: player2
		
		
		if((finalTotal1 > finalTotal2) || (p1Total > max && max > finalTotal2)) {
			whoWon = 2;
		}
		else if((finalTotal2 > finalTotal1) || (p2Total > max && max > finalTotal1)) {
			whoWon = 1;
		}
			
		return whoWon;
	}
}
