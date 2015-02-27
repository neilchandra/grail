package grailgames;

public class PrinceArthur extends RoyalDueler {
	
	public PrinceArthur(int damageTaken) {
		name = "Prince Arthur";
		attack = "Trivia Tackle";
		damage = 40;
		isAlive = true;
		maxHP = 120;
		hp = maxHP - damageTaken;
		xp = 0;
		arenaXP = 0;
	}
	
	@Override
	public Dueler advanceLevel() {
		return (new KingArthur(maxHP - hp));
	}

}
