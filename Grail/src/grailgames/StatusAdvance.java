package grailgames;

public class StatusAdvance extends TrainingCard implements ActUponDueler {
	
	//haha
	@Override
	public void actUpon(Dueler dueler) {
		dueler.advanceLevel();		
	}
}
