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
	
	/** The amount of levels a dueler has been in the arena posn. */
	protected int arenaXP;

	
	/** The attack damage of the currentAttack */
	protected int damage;

	/** Whether the dueler is alive or not */
	protected boolean isAlive;
	
	/**
	 * Adds HP points to a Dueler, but not exceeding maxHP
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
	
	@Override
	public String getName() {
		return (name);	
	}
	
	/**
	 * Subtracts HP points from a Dueler, and sets isAlive = false
	 * if currentHP reaches 0
	 * @param decrement - the amount of HP to be subtracted from currentHP
	 */
	public void subHP(int decrement) {
		if(hp - decrement <= 0) {
			hp = 0;
			isAlive = false;
		} else {
			hp -= decrement;			
		}
	}

	/**
	 * Increases the quantity maxHP by a certain amount
	 * @param increment - the amount to be added to maxHP
	 */
	public void addMaxHP(int increment) {
		System.out.println(name + "'s max HP increased by 20!");
		maxHP += increment;
	}
	
	/**
	 * Gets the value of maxHP
	 * @return - maxHP
	 */
	public int getMaxHP() {
		return maxHP;
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
	 * Returns the XP of the dueler
	 * @return - the xp of the dueler
	 */
	public int getXP() {
		return this.xp;
	}
	
	/**
	 * Exiles the dueler (i.e. sets isAlive to false)
	 */
	public void exile() {
		isAlive = false;
	}
	
	/** attack method */
	public abstract void attack(Dueler dueler);
	
	/** advance level method */
	public abstract Dueler advanceLevel();

	/** attacked by methods */
	public abstract void attackedByBrave(int damage);
	public abstract void attackedByCowardly(int damage);
	public abstract void attackedByPure(int damage);
	public abstract void attackedByRoyal(int damage);
	
	/** heal by holy health potion */
	public abstract void healByBrave();
	public abstract void healByCowardly();
	public abstract void healByPure();
	public abstract void healByRoyal();


	@Override
	public String toString() {
		return (name + ": " + hp +"/" + maxHP + "  Attack power: " + damage + "  XP: "
				+ xp);
	}
	
	/** Moves the dueler into the next available spot in field starting with the arena */
	public void play(Game c) {
		int openSpot = findOpenSpot(c.currentPlayer);
		if(openSpot == -1) { //no open spots
			System.out.println("Your field is full! You cannot play this dueler!");
		} else {
			c.currentPlayer.field[openSpot] = (Dueler) c.currentPlayer.hand.get(c.currentCard);
			System.out.println(c.currentPlayer.field[openSpot].getName() + " has entered the battle position!");
		}
		
	}
	
	/** Finds the next available spot open on the bench
	 * 
	 *  @return - returns the index which is open or -1 to represent a full bench
	 *  */
	public int findOpenSpot(Player player) {
		for(int x = 0; x < player.field.length; x++) {
			if(player.field[x] == null) {
				return x;
			}
		}
		return -1;
	}

	
}
