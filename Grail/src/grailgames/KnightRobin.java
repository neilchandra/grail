package grailgames;

public class KnightRobin extends CowardlyDueler {
	
	public KnightRobin(int damageTaken) {
		name = "Knight Robin";
		attack = "Camouflage";
		damage = 60;
		isAlive = true;
		maxHP = 120;
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
