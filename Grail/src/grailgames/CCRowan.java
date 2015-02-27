package grailgames;

public class CCRowan extends PureDueler {
	
	public CCRowan(int damage) {
		name = "CC Rowan";
		attack = "Rowan's Rampage";
		damage = 40;
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
