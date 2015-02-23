package grailgames;

public class BraveHolyHealthPotion extends HolyHealthPotion {
	
	public void actUpon(PureDueler dueler) {
		 dueler.addHP(10);
	}
	
	public void actUpon(BraveDueler dueler) {
		 dueler.addHP(30);
	}

	public void actUpon(CowardlyDueler dueler) {
		 dueler.addHP(10);
	}
	
	public void actUpon(RoyalDueler dueler) {
		 dueler.addHP(10);
	}

}
