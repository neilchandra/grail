package grailgames;

public class RoyalHolyHealthPotion extends HolyHealthPotion {
	
	@Override
	public void actUpon(Game game, int duelerIndex){
		Dueler[] duelers = game.otherPlayer.field;
		if (duelers[duelerIndex] == null) {
			System.out.println("No effect.");
		} else {
			duelers[duelerIndex].healByRoyal();
		}
	}

	public RoyalHolyHealthPotion() {
		name = "Royal Health";
	}

}
