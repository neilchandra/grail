package grailgames;

public abstract class PureDueler extends Dueler{

	@Override
	public void attack(Dueler dueler) {
		dueler.attackedByPure(currentDamage);
	}

	@Override
	public void attackedByBrave(int damage) {
		subHP(damage);
	}

	@Override
	public void attackedByCowardly(int damage) {
		subHP(damage - 20);
		
	}

	@Override
	public void attackedByPure(int damage) {
		subHP(damage);
	}

	@Override
	public void attackedByRoyal(int damage) {
		subHP(damage + 20);
		
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
