package grailgames;

public class BraveHolyHealthPotion extends HolyHealthPotion {

	/**
	 * Sets the name of the card
	 */
	public BraveHolyHealthPotion() {
		name = "Brave Health";
	}

	@Override
	public void actUpon(Game game, int duelerIndex) {
		Dueler[] duelers = game.currentPlayer.field;
		if (duelers[duelerIndex] == null) {
			System.out.println("No effect.");
		} else {
			duelers[duelerIndex].healByBrave();
		}
	}
}
