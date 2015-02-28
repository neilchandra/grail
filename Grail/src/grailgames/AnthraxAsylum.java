package grailgames;

public class AnthraxAsylum extends TrainingCard {

	/**
	 * Sets the name of the card
	 */
	public AnthraxAsylum() {
		name = "Anthrax Asylum";
	}

	@Override
	public void actUpon(Game game, int duelerIndex) {
		// increase hp to max
		Dueler dueler = game.currentPlayer.field[duelerIndex];
		if (dueler != null) {
			dueler.restoreHealth();
		} else {
			System.out.println("No effect.");
		}
	}
}
