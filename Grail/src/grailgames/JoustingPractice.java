package grailgames;

public class JoustingPractice extends TrainingCard implements ActUponDueler {

	@Override
	public void actUpon(Dueler dueler) {
		//add 20 to max hp and then 20 to current hp
		dueler.addMaxHP(20);
		dueler.addHP(20);
	}
	
	@Override 
	public void play(Player player, int index) {
		// get dueler number from reader, P
		
		if(player.field[P] != null) {
			actUpon(player.field[P]);
		} else {
			System.out.println("No effect.");
		}
		
		player.hand.remove(index);
	}
	
}
