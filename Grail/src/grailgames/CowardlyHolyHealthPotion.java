package grailgames;

public class CowardlyHolyHealthPotion extends HolyHealthPotion {

	@Override
	public void actUpon(Dueler dueler){
		dueler.healByCowardly();
	}
	
	public CowardlyHolyHealthPotion() {
		name = "Cowardly Health";
	}

}
