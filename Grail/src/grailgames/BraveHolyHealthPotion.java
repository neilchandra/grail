package grailgames;

public class BraveHolyHealthPotion extends HolyHealthPotion {
	
	@Override
	public void heal(Dueler dueler){
		dueler.healByBrave();
	}

	@Override
	public void play(Camelot c) {
		// TODO Auto-generated method stub
		
	}

/*	@Override
	public void play(Player player, int index) {
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
