package cardgame;
import java.util.*;
public class Game_Engine  extends PlayerTurn{
		
	/**
	 * Game_Engine class controls gameflow and playeractions
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
			/*Random_Deck to get list of 52 cards*/
			List<Card> random_Deck=new ArrayList<>();
			random_Deck=Card.getDeck();
			Collections.shuffle(random_Deck);//Shuffle the deck
			
			/*Creating object for player 1 and initialise cards for player 1 in Players_Action Constructor*/
			System.out.println("Player 1 Decks....");
			Players_Action player1=new Players_Action(random_Deck, 1);
			
			/*Creating object for player 2 and initialise cards for player 2 in Players_Action Constructor*/
			System.out.println("\nPlayer 2 Decks....");
			Players_Action player2=new Players_Action(random_Deck, 2);
			
			/*Passing player1,player2 objects and remaining deck of 38 cards to start method in PlayerTurn class*/
			Game_Engine start=new Game_Engine();
			start.start_game(player1,player2,random_Deck);
			
			
			
	}
}
