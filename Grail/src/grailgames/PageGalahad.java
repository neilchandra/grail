package grailgames;

public class PageGalahad extends PureDueler {
	
	/**
	 * Sets all the variables inherited from super classes
	 */
	public PageGalahad() {
		name = "Page Galahad";
		attack = "Chivalrous Cut";
		damage = 20;
		isAlive = true;
		maxHP = 60;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " has advanced to Squire Galahad!");
		return (new SquireGalahad(maxHP - hp));
	}
}
