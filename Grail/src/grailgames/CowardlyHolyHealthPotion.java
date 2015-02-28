package grailgames;

public class CowardlyHolyHealthPotion extends HolyHealthPotion {

	/**
	 * Sets the name of the card
	 */
	public CowardlyHolyHealthPotion() {
		name = "Cowardly Health";
	}

	@Override
	public void actUpon(Game game, int duelerIndex) {
		Dueler[] duelers = game.currentPlayer.field;
		if (duelers[duelerIndex] == null) {
			System.out.println("No effect.");
		} else {
			duelers[duelerIndex].healByCowardly();
		}
	}
}
