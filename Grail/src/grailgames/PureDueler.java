package grailgames;

public abstract class PureDueler extends Dueler{

	@Override
	public void attack(Dueler dueler) {
		System.out.println(name+" used " + attack+"!");
		dueler.attackedByPure(damage);
	}

	@Override
	public void attackedByBrave(int _damage) {
		subHP(_damage);
	}

	@Override
	public void attackedByCowardly(int _damage) {
		System.out.println("It's not very effective...");
		if(_damage - 20 > 0){
			subHP(_damage);
		} else {
			subHP(0);			
		}
		
	}

	@Override
	public void attackedByPure(int _damage) {
		subHP(_damage);
	}

	@Override
	public void attackedByRoyal(int _damage) {
		System.out.println("It was very effective!");
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
