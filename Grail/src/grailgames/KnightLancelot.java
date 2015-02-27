package grailgames;

public class KnightLancelot extends BraveDueler {
	
	public KnightLancelot(int damage) {
		name = "Knight Lancelot";
		attack = "Mighty Joust";
		damage = 50;
		isAlive = true;
		maxHP = 140;
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
