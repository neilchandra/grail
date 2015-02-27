package grailgames;

public class CCPatsy extends RoyalDueler {
	
	public CCPatsy(int damage) {
		name = "CC Patsy";
		attack = "Coconut Chuck";
		damage = 50;
		isAlive = true;
		maxHP = 100;
		hp = maxHP - damage;
		xp = 0;
		arenaXP = 0;
	}
	
	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " is at its highest level; cannot advance!");
		return this;
	}

}
