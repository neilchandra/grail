package grailgames;

public class StatusAdvance extends TrainingCard implements ActUponDueler {
	
	//sdfghjl;
	@Override
	public void actUpon(Dueler dueler) {
		dueler.advanceLevel();		
	}
}
