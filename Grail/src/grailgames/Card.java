package grailgames;

public abstract class Card {
	
	public String name;
	
	/**
	 * Produces a string describing the details of a Card
	 * @return - a string to to describe a Card
	 */
	@Override
	public abstract String toString();
	
	/**
	 * Performs specific card's action, moves dueler into field
	 * or enacts a training cards ability
	 */
	public void play() {
		
	}
}
