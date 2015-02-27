package grailgames;

public class PureHolyHealthPotion extends HolyHealthPotion {
	
	@Override
	public void actUpon(Game game, int duelerIndex){
		Dueler[] duelers = game.otherPlayer.field;
		if (duelers[duelerIndex] == null) {
			System.out.println("No effect.");
		} else {
			duelers[duelerIndex].healByPure();
		}
	}
	
	public PureHolyHealthPotion() {
		name = "Pure Health";
	}

}
