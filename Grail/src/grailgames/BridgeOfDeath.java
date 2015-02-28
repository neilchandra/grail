package grailgames;

public class BridgeOfDeath  extends TrainingCard  {

	/**
	 * Sets the name of the card
	 */
	public BridgeOfDeath() {
		name = "Bridge of Death";
	}

	@Override
	public void actUpon(Game game, int duelerIndex) {
		if (game.otherPlayer.field[duelerIndex] == null) {
			System.out.println("No effect.");
		} else { // dueler in index to be switched with
			Dueler d = game.otherPlayer.field[0];
			game.otherPlayer.field[0] = game.otherPlayer.field[duelerIndex];
			game.otherPlayer.field[duelerIndex] = d;
			System.out.println(game.otherPlayer.field[0].getName() + " was moved to the arena!");
			System.out.println(game.otherPlayer.field[duelerIndex].getName() + " was moved to the field!");
			game.otherPlayer.field[0].restartArenaXP();
			game.otherPlayer.field[duelerIndex].restartArenaXP();
		}
	}
}

