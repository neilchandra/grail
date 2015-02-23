package grailgames;

public class StatusAdvance extends TrainingCard implements ActUponDueler {
	
	//5th change
	@Override
	public void actUpon(Dueler dueler) {
		dueler.advanceLevel();		
	}
}
