package grailgames;

public abstract class PureDueler extends Dueler{

	@Override
	public void attack(Dueler dueler) {
		dueler.attackedByPure(damage);
	}

	@Override
	public void attackedByBrave(int _damage) {
		subHP(_damage);
	}

	@Override
	public void attackedByCowardly(int _damage) {
		subHP(_damage - 20);
		
	}

	@Override
	public void attackedByPure(int _damage) {
		subHP(_damage);
	}

	@Override
	public void attackedByRoyal(int _damage) {
		subHP(_damage + 20);
		
	}
	
	@Override
	public void healByBrave() {
		addHP(10);
	}

	@Override
	public void healByCowardly() {
		addHP(10);
		
	}

	@Override
	public void healByPure() {
		addHP(30);
		
	}

	@Override
	public void healByRoyal() {
		addHP(10);
		
	}

}
