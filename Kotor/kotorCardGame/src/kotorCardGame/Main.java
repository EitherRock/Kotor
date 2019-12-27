package kotorCardGame;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		//============== Class setup ==============================
		//card card = new card();
		Options options = new Options();
		PlayerHand hand1 = new PlayerHand();
		PlayerHand hand2 = new PlayerHand();
		NewRound nR = new NewRound();
		
		options.setUpDisplay();
		hand1.fillHand();
		hand2.fillHand();
		
		
		//==================== Game Setup ================================================
		
		//get input
		Scanner scan = new Scanner(System.in);
		int numInput = 0;
		
		String name1 = "Player 1";
		String name2 = "Player 2";
		
		int roundWins1 = 0;
		int roundWins2 = 0;
		
		LinkedList<Integer> player1Hand = hand1.getHand();
		LinkedList<Integer> player2Hand = hand2.getHand();
		
		int max = 20;
		
		
		//loop killers for game
		
		//main game loop killer
		boolean game = true;
		
		//player options loop killer
		boolean p1 = true;
		boolean p2 = true;
		
		
		//change player
		// 1 = player 1
		// 2 = player 2
		int turn = 1;
		
		//========================= card calculations ======================
	
		int cardNum = 0;
		
		//====================== Get game input ========================
		System.out.print("Enter Player 1 name: ");
		name1 = scan.next();
		System.out.println(" ");
		System.out.print("Enter Player 2 name: ");
		name2 = scan.next();
		System.out.println(" ");
		System.out.println("======================================");
		System.out.println("");
		
		
		// ===================== Game ====================================
		while(game) {
			
			
			//player one display/cards
			while(turn == 1 && !nR.p1Stand) {
				
				card card1 = new card();
				
				//generate card
				cardNum = card1.generateNumber();
				
				// add up total with new card
				nR.p1Total = nR.p1Total + cardNum;
				
				//add the new int from new card to string builder
				nR.str1.append(Integer.toString(cardNum));
				nR.str1.append(" ");
				
				hand1.mainDisplay(name1,nR.p1Total, nR.str1);
				options.displayOptions(); 
				
				// choose option 
				numInput = scan.nextInt();
				
				//checks if p2 is on stand and changes player
				while(p1) {
					
					p2 = true;
					
					if(numInput == 1) {
						if(nR.p2Stand) {
							p1 = false;
							turn = 1;
						}else {
							p1 = false;
							turn = 2;}
					
						
					}else if(numInput == 2) {
						nR.p1Stand = true;
						p1 = false;
						turn = 2;
					}else if(numInput == 3) {
						options.displayBack();
						options.displayUseHand(player1Hand);
					
					
						numInput = scan. nextInt();
						if(numInput <= player1Hand.size() && numInput > 0) {
							//System.out.println("working on it");
							nR.p1Total = nR.p1Total + options.cardChoice(numInput - 1, player1Hand);
							options.RemoveCard(numInput - 1, player1Hand);
							p1 = false;
							turn = 2;
						}
						else {
							hand1.mainDisplay(name1,nR.p1Total, nR.str1);
							options.displayOptions();
							numInput = scan.nextInt();
						}
					
					}
					else {
						System.out.println("Please choose an option");
						numInput = scan.nextInt();
					}	
				}
				System.out.println("======================================");
				System.out.println("");
			}
			
			System.out.println(nR.p1Stand);
			System.out.println(nR.p2Stand);
			
			
			//player two display/cards
			while(turn == 2 && !nR.p2Stand) {
				
				p1 = true;
				
				card card2 = new card();
				
				//generate card
				cardNum = card2.generateNumber();
				
				// add up total with new card
				nR.p2Total = nR.p2Total + cardNum;
				
				//add the new int from new card to string builder
				nR.str2.append(Integer.toString(cardNum));
				nR.str2.append(" ");
				//display game info
				hand2.mainDisplay(name2,nR.p2Total, nR.str2);
				options.displayOptions();
				
				numInput = scan.nextInt();
				while(p2) {
					if(numInput == 1) {
						if(nR.p1Stand) {
							p2 = false;
							turn = 2; 
							
						}else {
							p2 = false;
							turn = 1;}
					}
					else if(numInput == 2) {
						nR.p2Stand = true;
						p2 = false;
						turn = 1;
					}
					else if(numInput == 3) {
						options.displayBack();
						options.displayUseHand(player2Hand);
					
					
						numInput = scan. nextInt();
						if(numInput <= player2Hand.size() && numInput > 0) {
							System.out.println("working on it");
							p2 = false;
							turn = 1;
						}
						else {
							hand2.mainDisplay(name2,nR.p2Total, nR.str2);
							options.displayOptions();
						}
					
					}
					else {
						System.out.println("Please choose an option");
					}
				}
				System.out.println("======================================");
				System.out.println("");
			}	
				System.out.println(nR.p1Stand);
				System.out.println(nR.p2Stand);
			
			
			if(nR.checkRound(max) == 1) {
				System.out.println("======================");
				System.out.println(" ");
				System.out.printf("%s won the round!\n", name1);
				System.out.println(" ");
				System.out.println("======================");
				System.out.println(" ");
				roundWins1++;
				nR.createNewRound();
				turn = 1;
			}
			else if(nR.checkRound(max) == 2) {
				System.out.println("======================");
				System.out.println(" ");
				System.out.printf("%s won the round!\n", name2);
				System.out.println(" ");
				System.out.println("======================");
				System.out.println(" ");
				roundWins2++;
				nR.createNewRound();
				turn = 1;
			}
			
			else if(nR.p1Stand && nR.p2Stand || nR.isGameTied(max)) {
			
				if(nR.isGameTied(max)) {
					System.out.println("The game is Tied!");
					nR.createNewRound();
					turn = 1;
				}
				else if(nR.p1Stand && nR.p2Stand) {
					
					if(nR.totalDifference(max) == 1) {
						System.out.println("======================");
						System.out.println(" ");
						System.out.printf("%s won the round!\n", name1);
						System.out.println(" ");
						System.out.println("======================");
						System.out.println(" ");
						roundWins1++;
						nR.createNewRound();
						turn = 1;
					}
					else if(nR.totalDifference(max) == 2) {
						System.out.println("======================");
						System.out.println(" ");
						System.out.printf("%s won the round!\n", name2);
						System.out.println(" ");
						System.out.println("======================");
						System.out.println(" ");
						roundWins2++;
						nR.createNewRound();
						turn = 1;
					}
				}
			}
			
			if(roundWins1 == 3) {
				System.out.printf("%s won the game!", name1);
				game = false;
				scan.close();
			}
			else if(roundWins2 == 3) {
				System.out.printf("%s won the game!", name2);
				game = false;
				scan.close();
			}
		}
	}
}
