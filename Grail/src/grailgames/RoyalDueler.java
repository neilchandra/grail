package grailgames;

public abstract class RoyalDueler extends Dueler {

	@Override
	public void attack(Dueler dueler) {
		dueler.attackedByRoyal(currentDamage);
	}

	@Override
	public void attackedByBrave(int damage) {
		subHP(damage + 20);
	}

	@Override
	public void attackedByCowardly(int damage) {
		subHP(damage);
		
	}

	@Override
	public void attackedByPure(int damage) {
		subHP(damage - 20);
	}

	@Override
	public void attackedByRoyal(int damage) {
		subHP(damage);
		
	}
	
}
