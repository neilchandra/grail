package grailgames;

public class BraveHolyHealthPotion extends HolyHealthPotion {
	
	@Override
	public void actUpon(Game game, int duelerIndex) {
		Dueler[] duelers = game.otherPlayer.field;
		if (duelers[duelerIndex] == null) {
			System.out.println("No effect.");
		} else {
			duelers[duelerIndex].healByBrave();
		}
	}
	
	public BraveHolyHealthPotion() {
		name = "Brave Health";
	}

}
