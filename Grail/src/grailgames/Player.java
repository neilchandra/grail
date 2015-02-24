package grailgames;

import java.util.ArrayList;

public class Player {
	
	Dueler[] field;
	ArrayList<Card> hand;
	ArrayList<Card> deck;
	
	public Player(ArrayList<Card> deck) {
		this.field = new Dueler[7];
		this.hand = new ArrayList<Card>();
		this.deck = deck;	
	}

	public void play(int card) {
		Card playCard = hand.get(card); 
		// playCard.play()
	}
	
}
