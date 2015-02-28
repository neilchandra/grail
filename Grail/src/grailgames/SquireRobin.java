package grailgames;

public class SquireRobin extends CowardlyDueler {
	
	/**
	 * Sets all the variables inherited from super classes
	 * 
	 * @param damageTaken
	 *            - the damage already taken by the stage before this one
	 */
	public SquireRobin(int damageTaken) {
		name = "Squire Robin";
		attack = "Dash";
		damage = 30;
		isAlive = true;
		maxHP = 100;
		hp = maxHP - damageTaken;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " has advanced to Knight Robin!");
		return (new KnightRobin(maxHP - hp));
	}
}
