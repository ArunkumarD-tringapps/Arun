package cardgame;

/*
 * ========================
 * DO NOT MODIFY THIS FILE.
 * ========================
 */
import java.util.*;

/**
 * Represents an player's action on their turn: either they drew a card or they played a card.
 */
public class PlayerTurn {

    /**
     * The ID of the player that this action corresponds to
     */
    public int playerId;
    public int changeSuit;// used as flag for player whether have 8 or not
    
    
    public List<Card> play_Cards=new ArrayList<>();//play_Cards contains 7 players cards  
    

    /**
     * If the player drew a card on their turn
     */
    public boolean drewACard;

    /**
     * The card the player played on their turn, or null if the player didn't play a card.
     */
    public Card playedCard;
    public Card TopCard; //Top Card contains last played cards

    /**
     * When a player plays an "8", they can declare what suit the next player must play to.
     * <p>
     * If the player played an "8", this is the suit that they declared. Otherwise, this is null.
     */
    public Card.Suit declaredSuit;
    public Card.Suit Change;// change contains suit chosen by the player

    // Convenience methods; you might or might not need these.

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerTurn that = (PlayerTurn) o;
        return playerId == that.playerId &&
            drewACard == that.drewACard &&
            Objects.equals(playedCard, that.playedCard) &&
            declaredSuit == that.declaredSuit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, drewACard, playedCard, declaredSuit);
    }
    
    
    /*result will print players win*/
    public void result(Players_Action player1,Players_Action player2, List<Card> Deck) {
    	if(player1.play_Cards.size()==0)
    	{
    		System.out.println("player1 Wins");
    		System.out.println("player1 Inhand Cards : " + player1.play_Cards.size());
    		System.out.println("player2 Inhand Cards : " + player2.play_Cards.size());
    		System.out.println("Remaining Deck size : " + Deck.size());
    		
    	}
    	else if(player2.play_Cards.size()==0)
    	{
    		System.out.println("player2 Wins");
    		System.out.println("player1 Inhand Cards : " + player1.play_Cards.size());
    		System.out.println("player2 Inhand Cards : " + player2.play_Cards.size());
    		System.out.println("Remaining Deck size : " + Deck.size());
    	}
    	else if(Deck.size()==0)
    	{
    		System.out.println("Deck is Empty");
    		System.out.println("player1 Inhand Cards : " + player1.play_Cards.size());
    		System.out.println("player2 Inhand Cards : " + player2.play_Cards.size());
    		System.out.println("Remaining Deck size : " + Deck.size());
    	}
    	else {
    		System.out.println("Someone Cheated");
    		System.out.println("player1 Inhand Cards : " + player1.play_Cards.size());
    		System.out.println("player2 Inhand Cards : " + player2.play_Cards.size());
    		System.out.println("Remaining Deck size : " + Deck.size());
    	}
    }
    
    /*start game controls the gameflow */
    /*player 1 --  object for player1 */
    /*player 2 --  object for player2 */
    public void start_game(Players_Action player1,Players_Action player2, List<Card> Deck) {
    	player1.TopCard=Deck.get(0);
    	Deck.remove(0);
    	System.out.println("\nTop Card :"+ player1.TopCard.getSuit()+" "+ player1.TopCard.getRank());
    	boolean flag1=true,flag2=true;
    	player1.changeSuit=0;
    	player2.changeSuit=0;
    	while(true) {
    		if(player1.play_Cards.size()==0 || player2.play_Cards.size()==0 || Deck.size()==0 ) {
    			result(player1,player2,Deck);
    			break;
    		}
    		if(player1.changeSuit==0) {
    			flag1=player1.play();
    			
    			if(flag1==false) {
        			player1.drawFromDeck(Deck);
        			flag1=player1.play();
        			player2.TopCard=player1.TopCard;
        		}
        		else {
        			player2.TopCard=player1.TopCard;
        		}
    		}
    		else {
    			player2.Playfor8(player1.Change);
    			player1.TopCard=player2.TopCard;
    			player1.changeSuit=0;
    		}
    		if(player2.changeSuit==0) {
    				flag2=player2.play();
    				if(flag2==false) {
    						player2.drawFromDeck(Deck);
    						flag2=player2.play();
    						player1.TopCard=player2.TopCard;
    				}
    				else {
    						player1.TopCard=player2.TopCard;
    				}
    		 }
    		else {
    			player1.Playfor8(player2.Change);
    			player2.TopCard=player1.TopCard;
    			player2.changeSuit=0;
    		}
    	}
    	
    }
}
