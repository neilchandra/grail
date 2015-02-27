package grailgames;

public class CCConcorde extends BraveDueler {

	public CCConcorde(int damage) {
		name = "CC Concorde";
		attack = "Concorde's Conqueror";
		damage = 30;
		isAlive = true;
		maxHP = 70;
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
