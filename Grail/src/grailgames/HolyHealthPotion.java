package grailgames;

public abstract class HolyHealthPotion extends TrainingCard {
	
	public abstract void heal(Dueler dueler);
	
	@Override
	public void play(Player player, int index) {
		// read in the index for dueler, P
		
		if(player.field[P] != null) {
			heal(player.field[P]);
		} else {
			System.out.println("No effet.");
		}
		
		player.hand.remove(index);		
	}
}
