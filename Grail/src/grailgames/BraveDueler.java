package grailgames;

public abstract class BraveDueler extends Dueler {
	
	@Override
	public void attack(Dueler dueler) {
		dueler.attackedByBrave(currentDamage);
	}

	@Override
	public void attackedByBrave(int damage) {
		subHP(damage);
	}

	@Override
	public void attackedByCowardly(int damage) {
		subHP(damage + 20);
		
	}

	@Override
	public void attackedByPure(int damage) {
		subHP(damage);
	}

	@Override
	public void attackedByRoyal(int damage) {
		subHP(damage - 20);
		
	}

}
