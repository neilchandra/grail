package grailgames;

public class BoyArthur extends RoyalDueler {
	
	public BoyArthur() {
		name = "Boy Arthur";
		attack = "Royal Charm";
		damage = 20;
		isAlive = true;
		maxHP = 80;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		return (new PrinceArthur(maxHP - hp));
	}
}
