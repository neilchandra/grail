package grailgames;

public class CamelotReinforcements extends TrainingCard {
	
	/**
	 * Draws three new cards from Deck and places them 
	 * in Players hand
	 * @param player - the player who's turn it is
	 */
	public void actUpon(Player player) {
		player.drawCard();
		player.drawCard();
		player.drawCard();
	}

	@Override
	public void play(Camelot c) {
		//actUpon(player);
		//player.hand.remove(index);
	}
}
