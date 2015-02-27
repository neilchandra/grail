package grailgames;

public class StatusAdvance extends TrainingCard {

	@Override
	public void actUpon(Dueler dueler) {
		if(dueler.getXP() >= 3) {
		dueler = dueler.advanceLevel();	
		}
	}
	
	public StatusAdvance() {
		name = "Status Advance";
	}
}
