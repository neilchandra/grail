package grailgames;

public class AnthraxAsylum extends TrainingCard {

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
