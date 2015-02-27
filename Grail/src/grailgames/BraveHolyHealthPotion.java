package grailgames;

public class BraveHolyHealthPotion extends HolyHealthPotion {
	
	@Override
	public void actUpon(Dueler dueler){
		dueler.healByBrave();
	}
	
	public BraveHolyHealthPotion() {
		name = "Brave Health";
	}

}
