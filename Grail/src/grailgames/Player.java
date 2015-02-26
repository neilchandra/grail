package grailgames;

import java.util.ArrayList;


public class Player {

	private String name;
	public Dueler[] field;
	public ArrayList<Card> hand;
	ArrayList<Card> deck;

	public Player(String name, ArrayList<Card> deck) {
		this.name = name;
		this.deck = deck;
		this.field = new Dueler[7];
		this.hand = new ArrayList<Card>();
	}
	
	/** Find the next available spot in the field
	 * @return - the index of the available spot or -1 if field full 
	 */
	public int findEmptySpot(){
		for(int x = 0; x < 7; x++) {
			if(field[x] == null) {
				return x;
			}
		}
		return -1;
	}
 
	/** Plays Dueler card, moving it into the arena,
	 *  if empty, or to the bench, if not
	 *
	 * @param dueler - the dueler to be played
	 */
	public void addDuelerToField(int duelerLocation) {
		// Find empty spot in field
		int index = findEmptySpot();
	
		// If there is an empty spot add Dueler, if not, print message
		if(index != -1){
			field[index] = (Dueler) hand.get(duelerLocation);
		} else {
			System.out.println("Your field is full! You cannot put a dueler on the field.");
		}
	}
	
	
	/** Switches dueler in the arena with the dueler from the bench
	 * 
	 *  @param index - index of Dueler on the bench */
	public void switchDueler(int index) {
		if(field[0] != null) {
			if(field[index] != null) {
				
				// stores the dueler at index in the field
				Dueler tempD = field[index];
				
				// switches the duelers
				field[index] = field[0];
				field[0] = tempD;
			} else {
				
				// only moves dueler from arena to bench
				field[index] = field[0];
			}
		} else {
			System.out.println("There is no dueler in the arena. You cannot switch!");
		} 
	}
	
	/** Returns the name of the dueler
	 * 
	 * @return - the name of the dueler
	 */
	public String getName() {
		return this.name;
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
