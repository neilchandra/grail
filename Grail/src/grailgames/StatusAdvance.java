package grailgames;

public class StatusAdvance extends TrainingCard implements ActUponDueler {
	
	//Hello Neil
	@Override
	public void actUpon(Dueler dueler) {
		dueler.advanceLevel();		
	}
}
