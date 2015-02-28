package grailgames;

public class RoyalHolyHealthPotion extends HolyHealthPotion {
	
	/**
	 * Sets the name of the card
	 */
	public RoyalHolyHealthPotion() {
		name = "Royal Health";
	} 
	
	@Override
	public void actUpon(Game game, int duelerIndex){
		Dueler[] duelers = game.currentPlayer.field;
		if (duelers[duelerIndex] == null) {
			System.out.println("No effect.");
		} else {
			duelers[duelerIndex].healByRoyal();
		}
	}
}
