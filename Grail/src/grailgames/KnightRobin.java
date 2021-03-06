package grailgames;

public class KnightRobin extends CowardlyDueler {

	/**
	 * Sets all the variables inherited from super classes
	 * 
	 * @param damageTaken
	 *            - the damage already taken by the stage before this one
	 */
	public KnightRobin(int damageTaken) {
		name = "Knight Robin";
		attack = "Camouflage";
		damage = 60;
		isAlive = true;
		maxHP = 120;
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
	public void attackedByBrave(int _damage) {
		if (arenaXP < 2) {
			System.out.println("Knight Robin cannot be attacked at this time!");
		} else {
			System.out.println("It's not very effective...");
			if (_damage - 20 > 0) {
				subHP(_damage);
			} else {
				subHP(0);
			}
		}

	}

	@Override
	public void attackedByCowardly(int _damage) {
		if (arenaXP < 2) {
			System.out.println("Knight Robin cannot be attacked at this time!");
		} else {
			subHP(_damage);
		}
	}

	@Override
	public void attackedByPure(int _damage) {
		if (arenaXP < 2) {
			System.out.println("Knight Robin cannot be attacked at this time!");
		} else {
			System.out.println("It was very effective!");
			subHP(_damage + 20);
		}
	}

	@Override
	public void attackedByRoyal(int _damage) {
		if (arenaXP < 2) {
			System.out.println("Knight Robin cannot be attacked at this time!");
		} else {
			subHP(_damage);
		}
	}
}
