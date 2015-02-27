package grailgames;

public class SquireRobin extends CowardlyDueler {
	public SquireRobin() {
		name = "Squire Robin";
		attack = "Dash";
		damage = 30;
		isAlive = true;
		maxHP = 100;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}
	@Override
	public Dueler advanceLevel() {
		return (new KnightRobin());
	}
}
