package grailgames;

public class SquireGalahad extends PureDueler {
	
	public SquireGalahad(int damage) {
		name = "Squire Galahad";
		attack = "Gallant Gash";
		damage = 30;
		isAlive = true;
		maxHP = 90;
		hp = maxHP - damage;
		xp = 0;
		arenaXP = 0;
	}
	
	@Override
	public Dueler advanceLevel() {
		return (new KnightGalahad(maxHP - hp));
	}
	
}
