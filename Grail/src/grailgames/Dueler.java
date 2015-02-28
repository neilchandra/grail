package grailgames;

public abstract class Dueler extends Card {
	// to be implemented, just here for coding purposes

	/** The maximum health the dueler can have */
	protected int maxHP;

	/** The current value of the dueler's HP */
	protected int hp;

	/** The current attack of the dueler */
	protected String attack;

	/** The experience a dueler has in combat */
	protected int xp;
	
	/** The amount of levels a dueler has been
	 *  in the arena position.
	 */
	protected int arenaXP;

	/** The attack damage of the currentAttack */
	protected int damage;

	/** Whether the dueler is alive or not */
	protected boolean isAlive;
	
	/** Whether the dueler raises hp of others,
	 *  true for only Knight Galahad 
	 */
	protected boolean enhancesOthers = false;
	
	/** 
	 * Advances the dueler to the next stage/level
	 * 
	 * @return - the next level of the dueler 
	 */
	public abstract Dueler advanceLevel();
	
	/** 
	 * Attacks the given player from opponents arena
	 * 
	 * @param dueler - the opponents dueler in the arena
	 */
	public abstract void attack(Dueler dueler);

	/** 
	 * Method that tells Dueler it is being attacked 
	 * by a Brave Dueler
	 * 
	 * @param damage - the damage of the attack 
	 */
	public abstract void attackedByBrave(int damage);
	
	/** 
	 * Method that tells Dueler it is being attacked 
	 * by a Cowardly Dueler
	 * 
	 * @param damage - the damage of the attack 
	 */
	public abstract void attackedByCowardly(int damage);
	
	/** 
	 * Method that tells Dueler it is being attacked 
	 * by a Pure Dueler
	 * 
	 * @param damage - the damage of the attack 
	 */
	public abstract void attackedByPure(int damage);
	
	/** 
	 * Method that tells Dueler it is being attacked 
	 * by a Royal Dueler
	 * 
	 * @param damage - the damage of the attack 
	 */
	public abstract void attackedByRoyal(int damage);
	
	/** 
	 * Method that tells Dueler Brave Heath 
	 * is acting on it
	 */
	public abstract void healByBrave();
	
	/** 
	 * Method that tells Dueler Cowardly Heath 
	 * is acting on it
	 */
	public abstract void healByCowardly();
	
	/** 
	 * Method that tells Dueler Pure Heath 
	 * is acting on it
	 */
	public abstract void healByPure();
	
	/** 
	 * Method that tells Dueler Royal Heath 
	 * is acting on it
	 */
	public abstract void healByRoyal();
	
	/**
	 * Returns the hp
	 * 
	 * @return - the current health of the dueler
	 */
	public int getHP() {
		return hp;
	}
	
	/**
	 * Returns the maxHP
	 * 
	 * @return - the current health of the dueler
	 */
	public int getMaxHP() {
		return maxHP;
	}
	
	/**
	 * Adds HP points to a Dueler, but not exceeding maxHP
	 * 
	 * @param increment - the amount of HP to be added to currentHP
	 */
	public void addHP(int increment) {
		System.out.println(name + " recovered "+increment+" HP!");
		if(maxHP - hp <= increment){
			hp = maxHP;
		} else {
			hp += increment;			
		}
	}
	
	/**
	 * Subtracts HP points from a Dueler, and sets isAlive = false
	 * if currentHP reaches 0
	 * 
	 * @param decrement - the amount of HP to be subtracted from currentHP
	 */
	public void subHP(int decrement) {
		System.out.println(name +" took "+ decrement +" damage!");
		if(hp - decrement <= 0) {
			hp = 0;
			exile();
		} else {
			hp -= decrement;			
		}
	}
	
	/**
	 * Sets dueler's hp to 0
	 */
	public void depleteHP() {
		hp = 0;
	}
	
	/**
	 * Sets dueler's hp equal to maxHP
	 */
	public void restoreHealth() {
		hp = maxHP;
		System.out.println(getName()
				+ "'s health was fully restored!");
	}

	/**
	 * Increases the quantity maxHP by a certain amount
	 * 
	 * @param increment - the amount to be added to maxHP
	 */
	public void addMaxHP(int increment) {
		System.out.println(name + "'s max HP increased by 20!");
		maxHP += increment;
	}
	
	/**
	 * Returns the XP of the dueler
	 * 
	 * @return - the xp of the dueler
	 */
	public int getXP() {
		return this.xp;
	}
	
	/**
	 * Increments the current xp by 1
	 */
	public void addOneXP() {
		xp += 1;
	}
	
	/**
	 * Resets xp to 0
	 */
	public void xpToZero() {
		xp = 0;
	}

	/**
	 * Returns the arenaXp
	 * 
	 * @return - arenaXP
	 */
	public int getArenaXP() {
		return arenaXP;
	}
	
	/**
	 * Increments the current value of arena XP by 1
	 */
	public void addOneArenaXP() {
		arenaXP++;
		
	}
	
	/**
	 * Sets the arenaXP to 0
	 */
	public void restartArenaXP() {
		arenaXP = 0;
	}
	
	/**
	 * Exiles the dueler (i.e. sets isAlive to false)
	 */
	public void exile() {
		isAlive = false;
		depleteHP();
	}
	
	/**
	 * Indicates if a Dueler is alive
	 * 
	 * @return - isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}
	
	/**
	 * Indicates whether a dueler enhances other duelers in the field
	 * 
	 * @return - enhancesOthers
	 */
	public boolean isEnhancesOthers() {
		return enhancesOthers;
	}
	
	@Override
	public String toString() {
		return (name + ": " + hp +"/" + maxHP + "  Attack power: " + damage + "  XP: "
				+ xp);
	}
	
	/** 
	 * Finds the next available spot open on the bench
	 * 
	 * @return - returns the index of open empty spot or -1 if none
	 *  */
	public int findOpenSpot(Player player) {
		for (int x = 0; x < player.field.length; x++) {
			if (player.field[x] == null) {
				return x;
			}
		}
		return -1;
	}

	/**
	 * Moves the dueler into the next available spot in field starting with the
	 * arena
	 */
	public void play(Game c) {
		// Find next open spot in field
		int openSpot = findOpenSpot(c.currentPlayer);
		
		if (openSpot == -1) { // no open spots
			System.out
					.println("Your field is full! You cannot play this dueler!");
		} else {
			c.currentPlayer.field[openSpot] = (Dueler) c.currentPlayer.hand
					.get(c.currentCard);
			if (openSpot == 0) {
				System.out.println(c.currentPlayer.field[openSpot].getName()
						+ " has entered the battle position!");
			} else {
				System.out.println(c.currentPlayer.field[openSpot].getName()
						+ " was placed on the bench!");
			}
		}

	}

}
