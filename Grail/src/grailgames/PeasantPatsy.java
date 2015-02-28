package grailgames;

public class PeasantPatsy extends RoyalDueler {

	/**
	 * Sets all the variables inherited from super classes
	 */
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
