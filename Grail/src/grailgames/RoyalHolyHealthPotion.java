package grailgames;

public class RoyalHolyHealthPotion extends HolyHealthPotion {
	
	@Override
	public void actUpon(Dueler dueler){
		dueler.healByRoyal();
	}


}
