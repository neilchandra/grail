package grailgames;

public class PureHolyHealthPotion extends HolyHealthPotion {
	
	@Override
	public void actUpon(PureDueler dueler) {
		 dueler.addHP(30);
	}
	
	@Override
	public void actUpon(BraveDueler dueler) {
		 dueler.addHP(10);
	}

	@Override
	public void actUpon(CowardlyDueler dueler) {
		 dueler.addHP(10);
	}
	
	@Override
	public void actUpon(RoyalDueler dueler) {
		 dueler.addHP(10);
	}



}
