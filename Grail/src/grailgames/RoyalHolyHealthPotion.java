package grailgames;

public class RoyalHolyHealthPotion extends HolyHealthPotion {
	
	@Override
	public void heal(Dueler dueler){
		dueler.healByRoyal();
	}


}
