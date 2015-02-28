package grailgames;

public class PrinceArthur extends RoyalDueler {

	/**
	 * Sets all the variables inherited from super classes
	 * 
	 * @param damageTaken
	 *            - the damage already taken by the stage before this one
	 */
	public PrinceArthur(int damageTaken) {
		name = "Prince Arthur";
		attack = "Trivia Tackle";
		damage = 40;
		isAlive = true;
		maxHP = 120;
		hp = maxHP - damageTaken;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " has advanced to King Arthur!");
		return (new KingArthur(maxHP - hp));
	}
}
