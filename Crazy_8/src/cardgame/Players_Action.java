package cardgame;
import java.util.*;
public class Players_Action extends PlayerTurn {
				
				/*Constructor to assign cards for each players*/
				Players_Action(List<Card> deck,int id){
					
					playerId=id;
					for(int i=0;i<7;i++) {
						play_Cards.add(deck.get(0));
						deck.remove(0);
					}
					for(int i=0;i<7;i++) {
						System.out.print(play_Cards.get(i).getSuit()+" "+play_Cards.get(i).getRank()+", ");
					}
				}
				
				/*Playfor8() method will provide cards which matches with opponent who declared the suit  */
				public void Playfor8(Card.Suit change) {
					
					for(int i=0;i<this.play_Cards.size();i++) {
						if(this.play_Cards.get(i).getSuit().equals(this.Change)) {
							System.out.println("Suit available for player"+this.playerId);
							System.out.println("Selcted card is...."+this.play_Cards.get(i).getSuit()+" "+this.play_Cards.get(i).getRank());
							this.TopCard=this.play_Cards.get(i);
							this.play_Cards.remove(i);
						}
					}
				
							
				}
				
				/*changeSuit() will check players suit count and set change.suit value with maximum suit*/
				/*This Method  to choose the suit for player*/
				public void changeSuit() {
					this.changeSuit=1;
					
					int club=0,diamond=0,spade=0,heart=0;
					
					System.out.println("Player "+ playerId +" Choosing Suit ");
					for(int i=0;i<play_Cards.size();i++) {
							if(play_Cards.get(i).getSuit()==Card.Suit.CLUBS) {
								club++;
							}
							else if(play_Cards.get(i).getSuit()==Card.Suit.DIAMONDS) {
								diamond++;
							}
							else if(play_Cards.get(i).getSuit()==Card.Suit.SPADES) {
								spade++;
							}
							else {
								heart++;
							}
					}
					if(club>diamond&&club>spade&&club>heart) {
						this.Change=Card.Suit.CLUBS; 
					}
					else if(diamond>club&&diamond>spade&&diamond>heart) {
						this.Change=Card.Suit.DIAMONDS;
					}
					else if(spade>club&&spade>diamond&&spade>heart) {
						this.Change=Card.Suit.SPADES;
					}
					else {
						this.Change=Card.Suit.HEARTS;
					}
					
					
				}
				
				/*play() method will compare player cards with top card and return true if available or return false*/
				/*If player have No 8 card, it calls sub method changesuit()*/
				public boolean play() {
					for(int i=0;i<this.play_Cards.size();i++) {
						if(play_Cards.get(i).getRank()==Card.Rank.EIGHT) {
							this.TopCard=play_Cards.get(0);
							play_Cards.remove(0);
							changeSuit();
							return true;
						}
						else if(this.play_Cards.get(i).getSuit().equals(this.TopCard.getSuit()) || this.play_Cards.get(i).getRank().equals(this.TopCard.getRank())) {
										this.TopCard=this.play_Cards.get(i);
										System.out.println("Player "+this.playerId+" Turns.."+this.TopCard.getSuit()+" "+this.TopCard.getRank());
										this.play_Cards.remove(i);
										return true;
						}
					}
					return false;
					
				}
				
				/*drawFromDeck() will provide cards for players if they do not have any match*/
				public void drawFromDeck(List<Card> Deck) {
								
						int i=0,count=0;
						boolean available=false;
						while(i<3 && available==false) {
								this.play_Cards.add(Deck.get(0));
								count++;
								if(Deck.get(0).getRank().equals(TopCard.getRank()) || Deck.get(0).getSuit().equals(TopCard.getSuit()) || Deck.get(0).getRank()== Card.Rank.EIGHT) {
									available=true;
									System.out.println("Available for "+this.playerId);
									System.out.println("Available at "+count+" times");
								}
								i++;
								Deck.remove(0);
						}
				}
}
