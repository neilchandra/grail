package grailgames;

public class MinstrelMerek extends CowardlyDueler {

	public MinstrelMerek(int damageTaken) {
		name = "MinstrelMerek";
		attack = "Lute Laceration";
		damage = 50;
		isAlive = true;
		maxHP = 150;
		hp = maxHP - damageTaken;
		xp = 0;
		arenaXP = 0;
	}
	
	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " is at its highest level; cannot advance!");
		return this;
		
	}
}
