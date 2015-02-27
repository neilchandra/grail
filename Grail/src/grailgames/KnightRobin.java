package grailgames;

public class KnightRobin extends CowardlyDueler {
	
	public KnightRobin() {
		name = "Knight Robin";
		attack = "Camouflage";
		damage = 60;
		isAlive = true;
		maxHP = 120;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}
	
	@Override
	public Dueler advanceLevel() {
		return this;
	}

}
