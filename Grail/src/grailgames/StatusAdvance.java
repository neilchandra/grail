package grailgames;

public class StatusAdvance extends TrainingCard implements ActUponDueler {

	//this should have trouble mergin 2
	@Override
	public void actUpon(Dueler dueler) {
		dueler.advanceLevel();		
	}
	
	@Override
	public void play(Player player, int index){
		// read in dueler index, P

		if (player.field[P] != null) {
			if (player.field[P].getXP() >= 3) {
				actUpon(player.field[P]);
			} else {
				System.out
						.println("This Dueler is not yet experienced enough to increase status!");
			}
		} else {
			System.out.println("No effect.");
		}

		player.hand.remove(index);
		
	}
}
