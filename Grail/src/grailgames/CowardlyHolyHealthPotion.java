package grailgames;

public class CowardlyHolyHealthPotion extends HolyHealthPotion {

	@Override
	public void heal(Dueler dueler){
		dueler.healByCowardly();
	}

	@Override
	public void play(Camelot c) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override(non-Javadoc)
	 * @see grailgames.HolyHealthPotion#play(grailgames.Player, int)
	 */
/*	public void play(Player player, int index) {
		// read in the index for dueler, P
		
		if(player.field[P] != null) {
			heal(player.field[P]);
		} else {
			System.out.println("No effet.");
		}
		
		player.hand.remove(index);		
	}
	*/
}
