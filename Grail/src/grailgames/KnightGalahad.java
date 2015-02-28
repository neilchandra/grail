package grailgames;

public class KnightGalahad extends PureDueler {

	/**
	 * Sets all the variables inherited from super classes
	 * 
	 * @param damageTaken
	 *            - the damage already taken by the stage before this one
	 */
	public KnightGalahad(int damageTaken) {
		name = "Knight Galahad";
		attack = "Punch of Purity";
		damage = 60;
		isAlive = true;
		maxHP = 120;
		hp = maxHP - damageTaken;
		xp = 0;
		arenaXP = 0;
		enhancesOthers = true;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " is at its highest level; cannot advance!");
		return this;
	}
}
