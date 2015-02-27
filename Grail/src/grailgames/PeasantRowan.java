package grailgames;

public class PeasantRowan extends PureDueler {

	public PeasantRowan() {
		name = "Peasant Rowan";
		attack = "Roundhouse Kick";
		damage = 20;
		isAlive = true;
		maxHP = 80;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}
	
	@Override
	public Dueler advanceLevel() {
		return (new CCRowan());
	}

	
}
