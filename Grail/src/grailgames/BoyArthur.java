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
		System.out.println(name + " has advanced to Prince Arthur!");
		return (new PrinceArthur(maxHP - hp));
	}
}
