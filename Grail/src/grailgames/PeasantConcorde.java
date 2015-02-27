package grailgames;

public class PeasantConcorde extends BraveDueler {
	
	public PeasantConcorde() {
		name = "Peasant Concorde";
		attack = "Brave Bite";
		damage = 30;
		isAlive = true;
		maxHP = 40;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " has advanced to CC Concorde!");
		return (new CCConcorde(maxHP - hp));
	}
}
