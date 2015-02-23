package grailgames;

public class StatusAdvance extends TrainingCard implements ActUponDueler {
	
	//6th change dawg
	@Override
	public void actUpon(Dueler dueler) {
		dueler.advanceLevel();		
	}
}
