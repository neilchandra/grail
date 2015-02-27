package grailgames;

public class KingArthur extends RoyalDueler {

	public KingArthur(int damage) {
		name = "King Arthur";
		attack = "Excalibur";
		damage = 50;
		isAlive = true;
		maxHP = 160;
		hp = maxHP - damage;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " is at its highest level; cannot advance!");
		return this;
	}

}
