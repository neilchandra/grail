package grailgames;

public class PeasantPatsy extends RoyalDueler {

	public PeasantPatsy() {
		name = "Peasant Patsy";
		attack = "Patsy Punch";
		damage = 30;
		isAlive = true;
		maxHP = 60;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " has advanced to CC Patsy!");
		return new CCPatsy(maxHP - hp);
	}

	
}
