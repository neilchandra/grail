package grailgames;

public class CCPatsy extends RoyalDueler {
	
	public CCPatsy(int damageTaken) {
		name = "CC Patsy";
		attack = "Coconut Chuck";
		damage = 50;
		isAlive = true;
		maxHP = 100;
		hp = maxHP - damageTaken;
		xp = 0;
		arenaXP = 0;
	}
	
	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " is at its highest level; cannot advance!");
		return this;
	}

}
