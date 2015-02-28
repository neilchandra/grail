package grailgames;

public class PageLancelot extends BraveDueler {

	/**
	 * Sets all the variables inherited from super classes
	 */
	public PageLancelot() {
		name = "Page Lancelot";
		attack = "Punch of Fury";
		damage = 20;
		isAlive = true;
		maxHP = 60;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " has advanced to Squire Lancelot!");
		return (new SquireLancelot(maxHP - hp));
	}
}
