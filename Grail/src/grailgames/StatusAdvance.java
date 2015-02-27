package grailgames;

public class StatusAdvance extends TrainingCard {

	@Override
	public void actUpon(Dueler dueler) {
		dueler = dueler.advanceLevel();		
	}
	
	public StatusAdvance() {
		name = "Status Advance";
	}
}
