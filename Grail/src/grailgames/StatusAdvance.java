package grailgames;

public class StatusAdvance extends TrainingCard implements ActUponDueler {
	
	//bleh
	@Override
	public void actUpon(Dueler dueler) {
		dueler.advanceLevel();		
	}
}
