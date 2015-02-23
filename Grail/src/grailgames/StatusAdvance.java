package grailgames;

public class StatusAdvance extends TrainingCard implements ActUponDueler {

	//this should have trouble mergin 2
	@Override
	public void actUpon(Dueler dueler) {
		dueler.advanceLevel();		
	}
}
