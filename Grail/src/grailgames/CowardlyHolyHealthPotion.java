package grailgames;

public class CowardlyHolyHealthPotion extends HolyHealthPotion {

	@Override
	public void actUpon(Game game, int duelerIndex){
		Dueler[] duelers = game.otherPlayer.field;
		if (duelers[duelerIndex] == null) {
			System.out.println("No effect.");
		} else {
			duelers[duelerIndex].healByCowardly();
		}
	}
	
	public CowardlyHolyHealthPotion() {
		name = "Cowardly Health";
	}

}
