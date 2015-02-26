package grailgames;

public abstract class CowardlyDueler extends Dueler{

	@Override
	public void attack(Dueler dueler) {
		dueler.attackedByCowardly(currentDamage);
	}

	@Override
	public void attackedByBrave(int damage) {
		subHP(damage - 20);
	}

	@Override
	public void attackedByCowardly(int damage) {
		subHP(damage);
		
	}

	@Override
	public void attackedByPure(int damage) {
		subHP(damage + 20);
	}

	@Override
	public void attackedByRoyal(int damage) {
		subHP(damage);
		
	}

	
}
