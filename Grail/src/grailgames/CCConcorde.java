package grailgames;

public class CCConcorde extends BraveDueler {
	
	/**
	 * Sets all the variables inherited from super classes
	 * 
	 * @param damageTaken
	 *            - the damage already taken by the stage before this one
	 */
	public CCConcorde(int damageTaken) {
		name = "CC Concorde";
		attack = "Concorde's Conqueror";
		damage = 30;
		isAlive = true;
		maxHP = 70;
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
