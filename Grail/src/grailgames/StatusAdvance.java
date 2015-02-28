package grailgames;

public class StatusAdvance extends TrainingCard {

	/**
	 * Sets the name of the card
	 */
	public StatusAdvance() {
		name = "Status Advance";
	}
	
	@Override
	public void actUpon(Game game, int duelerIndex) {
		Dueler[] duelers = game.currentPlayer.field;
		if (duelers[duelerIndex] != null) {
			if (duelers[duelerIndex].getXP() >= 3) {
				duelers[duelerIndex] = duelers[duelerIndex].advanceLevel();
			} else {
				System.out.println("This Dueler is not yet experiencd enough to increase status!");
			}
		} else {
			System.out.println("No effect.");
		}
	}

}
