package grailgames;

public class KingArthur extends RoyalDueler {

	public KingArthur() {
		name = "King Arthur";
		attack = "Excalibur";
		damage = 50;
		isAlive = true;
		maxHP = 160;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		return this;
	}

}
