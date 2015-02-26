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
				
				System.out.println(field[0].getName()+" was placed on the bench!");
				System.out.println(field[index].getName()+" has entered the battle position!");
				
				// stores the dueler at index in the field
				Dueler tempD = field[index];
				
				// switches the duelers
				field[index] = field[0];
				field[0] = tempD;
			} else {
				
				// only moves dueler from arena to bench
				System.out.println(field[0].getName()+" was placed on the bench!");
				field[index] = field[0];
				field[0] = null;
			}
		} else { //arena position empty
			if(field[index] == null){
				System.out.println("Not a valid switch!");	
			} else { //battle position empty but bench slot not empty
				System.out.println(field[index].getName()+" has entered the battle position!");
				field[0] = field[index];
				field[index] = null;
			}
			
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
		if (!deck.isEmpty()) {
			hand.add(deck.remove(0));
			System.out.println(name+" drew a card.");
		} else {
			System.out.println(name + "'s deck is empty.");
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
	public void printField() {
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
