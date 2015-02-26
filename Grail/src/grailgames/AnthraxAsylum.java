package grailgames;

public class AnthraxAsylum extends TrainingCard implements ActUponDueler {

	@Override
	public void actUpon(Dueler dueler) {
		// increase hp to max
		dueler.addHP(dueler.getMaxHP());			
		System.out.println(dueler.getName() + "'s health was fully restored");
	}
	
	@Override
	public void play(Player player, int index) {
		if(field[/* variable from reader */] != null) {
			actUpon(player.field[/* variable from reader*/]);
			
		} else {
			System.out.print("No effect.");
		}
		player.hand.remove(index);                 
	}
	
}
