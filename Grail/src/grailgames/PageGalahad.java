package grailgames;

public class PageGalahad extends PureDueler {
	
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
		return (new SquireGalahad(maxHP - hp));
	}

}
