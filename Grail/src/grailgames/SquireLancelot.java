package grailgames;

public class SquireLancelot extends BraveDueler {

	public SquireLancelot(int damageTaken) {
		name = "Squire Lancelot";
		attack = "Sword Stab";
		damage = 30;
		isAlive = true;
		maxHP = 100;
		hp = maxHP - damageTaken;
		xp = 0;
		arenaXP = 0;
	}
	
	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " has advanced to Knight Lancelot!");
		return (new KnightLancelot(maxHP - hp));
	}
	
}
