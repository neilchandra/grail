package grailgames;

public class PureHolyHealthPotion extends HolyHealthPotion {
	
	@Override
	public void actUpon(Dueler dueler){
		dueler.healByPure();
	}
	
	public PureHolyHealthPotion() {
		name = "Pure Health";
	}

}
