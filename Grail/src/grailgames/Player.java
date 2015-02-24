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

	/** Draws cards from deck and places in hand */
	public void drawCard() {
		if (deck.isEmpty()) {
			hand.add(deck.get(1));
			deck.remove(1);
		} else {
			System.out.println("Your deck is empty! Fight to the death!");
		}
	}

	/** Prints the entire hand of the player */
	public void printHand() {
		int index = 0;
		if (hand.isEmpty()) {
			for (Card c : hand) {
				System.out.println(index + ". " + c.getName());
			}
		} else {
			System.out.println("Your hand is empty!");
		}
	}

	/** Prints the player's field */
	public void printfield() {
		int index = 0;
		for (int x = 0; x < 7; x++) {
			if (field[x] == null) {
				System.out.println(index + ". empty");
			} else {
				System.out.println(index + ". " + field[x].toString());
			}
		}
	}

}
