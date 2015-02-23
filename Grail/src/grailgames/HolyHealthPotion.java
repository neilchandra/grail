package grailgames;

public abstract class HolyHealthPotion extends TrainingCard{
	
	public abstract void actUpon(PureDueler dueler);
	
	public abstract void actUpon(BraveDueler dueler) ;

	public abstract void actUpon(CowardlyDueler dueler);
	
	public abstract void actUpon(RoyalDueler dueler);
	
}
