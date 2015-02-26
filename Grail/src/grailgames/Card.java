package grailgames;

public abstract class Card {
	
	public String name;
	
	/**
	 * Produces the name of the card
	 * @return - name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Performs specific card's action, moves dueler into field
	 * or enacts a training cards ability
	 */
	public abstract void play(Camelot c);
}
