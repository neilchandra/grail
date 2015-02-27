package grailgames;

public class PageLancelot extends BraveDueler {

	public PageLancelot() {
		name = "Page Lancelot";
		attack = "Punch of Fury";
		damage = 20;
		isAlive = true;
		maxHP = 60;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}
	
	@Override
	public Dueler advanceLevel() {
		return (new SquireLancelot());
	}


}
