package grailgames;

public class CCRowan extends PureDueler {
	
	/**
	 * Sets all the variables inherited from super classes
	 * 
	 * @param damageTaken
	 *            - the damage already taken by the stage before this one
	 */
	public CCRowan(int damageTaken) {
		name = "CC Rowan";
		attack = "Rowan's Rampage";
		damage = 40;
		isAlive = true;
		maxHP = 100;
		hp = maxHP - damageTaken;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " is at its highest level; cannot advance!");
		return this;
	}
}
