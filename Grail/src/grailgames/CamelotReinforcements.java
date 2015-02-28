package grailgames;

public class CamelotReinforcements extends TrainingCard {

	/**
	 * Sets the name of the card
	 */
	public CamelotReinforcements() {
		name = "Camelot Reinforcements";
	}
	
	@Override
	public void play(Game c) {
		System.out.println(c.currentPlayer.getName()+" used Camelot Reinforcements!");
		c.currentPlayer.drawCard();
		c.currentPlayer.drawCard();
		c.currentPlayer.drawCard();
	}

	@Override
	public void actUpon(Game game, int duelerIndex) {
		//not needed
	}

}
