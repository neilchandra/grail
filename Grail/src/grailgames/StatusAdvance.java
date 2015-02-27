package grailgames;

public class StatusAdvance extends TrainingCard implements ActUponDueler {

	@Override
	public void actUpon(Dueler dueler) {
		dueler = dueler.advanceLevel();		
	}
	
}
