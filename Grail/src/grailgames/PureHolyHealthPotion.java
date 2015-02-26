package grailgames;

public class PureHolyHealthPotion extends HolyHealthPotion {
	
	@Override
	public void heal(Dueler dueler){
		dueler.healByPure();
	}



}
