package grailgames;

public class PeasantRowan extends PureDueler {

	/**
	 * Sets all the variables inherited from super classes
	 */
	public PeasantRowan() {
		name = "Peasant Rowan";
		attack = "Roundhouse Kick";
		damage = 20;
		isAlive = true;
		maxHP = 80;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " has advanced to CC Rowan!");
		return (new CCRowan(maxHP - hp));
	}
}
