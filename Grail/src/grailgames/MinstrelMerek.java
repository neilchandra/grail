package grailgames;

public class MinstrelMerek extends CowardlyDueler {

	/**
	 * Sets all the variables inherited from super classes
	 * 
	 * @param damageTaken
	 *            - the damage already taken by the stage before this one
	 */
	public MinstrelMerek(int damageTaken) {
		name = "MinstrelMerek";
		attack = "Lute Laceration";
		damage = 50;
		isAlive = true;
		maxHP = 150;
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
