package grailgames;

public class SquireGalahad extends PureDueler {
	
	/**
	 * Sets all the variables inherited from super classes
	 * 
	 * @param damageTaken
	 *            - the damage already taken by the stage before this one
	 */
	public SquireGalahad(int damageTaken) {
		name = "Squire Galahad";
		attack = "Gallant Gash";
		damage = 30;
		isAlive = true;
		maxHP = 90;
		hp = maxHP - damageTaken;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " has advanced to Knight Galahad!");
		return (new KnightGalahad(maxHP - hp));
	}
}
