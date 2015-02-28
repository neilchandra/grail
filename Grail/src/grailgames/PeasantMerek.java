package grailgames;

public class PeasantMerek extends CowardlyDueler {
	
	/**
	 * Sets all the variables inherited from super classes
	 */
	public PeasantMerek() {
		name = "Peasant Merek";
		attack = "Ballad Bash";
		damage = 0;
		isAlive = true;
		maxHP = 100;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " has advanced to Minstrel Merek!");
		return (new MinstrelMerek(maxHP - hp));

	}
}
