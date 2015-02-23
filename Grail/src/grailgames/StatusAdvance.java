package grailgames;

public class StatusAdvance extends TrainingCard implements ActUponDueler {
	
		//si se puede
	@Override
	public void actUpon(Dueler dueler) {
		dueler.advanceLevel();		
	}
}
