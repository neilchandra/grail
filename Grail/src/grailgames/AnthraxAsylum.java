package grailgames;

public class AnthraxAsylum extends TrainingCard implements ActUponDueler {

	@Override
	public void actUpon(Dueler dueler) {
		// increase hp to max
		dueler.addHP(dueler.getMaxHP());			
	}
	
	public void play(Player player, int index) {
		player
	}
	
}
