package grailgames;

public class JoustingPractice extends TrainingCard {

	@Override
	public void actUpon(Dueler dueler) {
		//add 20 to max hp and then 20 to current hp
		dueler.addMaxHP(20);
		dueler.addHP(20);
	}
	
	public JoustingPractice() {
		name = "Jousting Practice";
	}
	
	
}
