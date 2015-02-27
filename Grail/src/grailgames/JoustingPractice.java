package grailgames;

public class JoustingPractice extends TrainingCard {

	@Override
	public void actUpon(Game game, int duelerIndex) {
		//add 20 to max hp and then 20 to current hp
		Dueler dueler = game.currentPlayer.field[duelerIndex];
		if (dueler != null) {
			dueler.addMaxHP(20);
			dueler.addHP(20);
		} else {
			System.out.println("No effect.");
		}
	}
	
	public JoustingPractice() {
		name = "Jousting Practice";
	}
	
	
}
