package grailgames;

public abstract class CowardlyDueler extends Dueler{

	@Override
	public void attack(Dueler dueler) {
		dueler.attackedByCowardly(damage);
	}

	@Override
	public void attackedByBrave(int _damage) {
		subHP(_damage - 20);
		System.out.println(name + "has lost " + (_damage - 20) + "health!");
	}

	@Override
	public void attackedByCowardly(int _damage) {
		subHP(_damage);
		System.out.println(name + "has lost " + _damage + "health!");
	}

	@Override
	public void attackedByPure(int _damage) {
		subHP(_damage + 20);
		System.out.println(name + "has lost " + (_damage + 20) + "health!");
	}

	@Override
	public void attackedByRoyal(int _damage) {
		subHP(_damage);
		System.out.println(name + "has lost " + _damage + "health!");
	}
	
	@Override
	public void healByBrave() {
		addHP(10);
		System.out.println(name + "has recovered 10 health!");
	}

	@Override
	public void healByCowardly() {
		addHP(30);
		System.out.println(name + "has recovered 30 health!");
	}

	@Override
	public void healByPure() {
		addHP(10);
		System.out.println(name + "has recovered 10 health!");
	}

	@Override
	public void healByRoyal() {
		addHP(10);
		System.out.println(name + "has recovered 10 health!");
	}

	
}
