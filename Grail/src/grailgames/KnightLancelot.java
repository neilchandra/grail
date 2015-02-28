package grailgames;

public class KnightLancelot extends BraveDueler {
	
	/**
	 * Sets all the variables inherited from super classes
	 * 
	 * @param damageTaken
	 *            - the damage already taken by the stage before this one
	 */
	public KnightLancelot(int damageTaken) {
		name = "Knight Lancelot";
		attack = "Mighty Joust";
		damage = 50;
		isAlive = true;
		maxHP = 140;
		hp = maxHP - damageTaken;
		xp = 0;
		arenaXP = 0;
	}

	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " is at its highest level; cannot advance!");
		return this;
	}

	@Override
	public void attack(Dueler dueler) {
		System.out.println(name + " used " + attack + "!");
		dueler.attackedByBrave(damage);
		damage += 5; // special power
	}
}
