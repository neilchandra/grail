package grailgames;

public abstract class Dueler extends Card implements Advanceable {
	// to be implemented, just here for coding purposes

	/** The maximum health the dueler can have */
	protected int maxHP;

	/** The current value of the dueler's HP */
	protected int currentHP;

	/** The current attack of the dueler */
	protected String currentAttack;

	/** The experience a dueler has in combat */
	protected int xp;

	/** The title which the dueler has */
	protected String currentStage;
	
	/** The attack damage of the currentAttack */
	protected int currentDamage;

	/** Whether the dueler is alive or not */
	protected boolean isAlive;
	
	/**
	 * Adds HP points to a Dueler, but not exceeding maxHP
	 * @param increment - the amount of HP to be added to currentHP
	 */
	public void addHP(int increment) {
		if(maxHP - currentHP <= increment){
			currentHP = maxHP;
		} else {
			currentHP += increment;			
		}
	}
	
	/**
	 * Subtracts HP points from a Dueler, and sets isAlive = false
	 * if currentHP reaches 0
	 * @param decrement - the amount of HP to be subtracted from currentHP
	 */
	public void subHP(int decrement) {
		if(this.currentHP - decrement <= 0) {
			this.currentHP = 0;
			this.isAlive = false;
		} else {
			currentHP -= decrement;			
		}
	}

	/**
	 * Increases the quantity maxHP by a certain amount
	 * @param increment - the amount to be added to maxHP
	 */
	public void addMaxHP(int increment) {
		maxHP += increment;
	}
	
	/**
	 * Gets the value of maxHP
	 * @return - maxHP
	 */
	public int getMaxHP() {
		return maxHP;
	}
	
	/** double dispatch attack methods */
	public abstract void attack(BraveDueler dueler);
	public abstract void attack(CowardlyDueler dueler);
	public abstract void attack(PureDueler dueler);
	public abstract void attack(RoyalDueler dueler);


	@Override
	public String toString() {
		return (this.currentStage + " " + this.name + ": HP - "
				+ this.currentHP + "MaxHP - " + this.maxHP + " XP - " + xp);
	}

}
