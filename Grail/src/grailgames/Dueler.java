package grailgames;

public abstract class Dueler extends Card implements Advanceable {
	// to be implemented, just here for coding purposes

	/** The maximum health the dueler can have */
	private int maxHP;

	/** The current value of the dueler's HP */
	private int currentHP;

	/** The experience a dueler has in combat */
	private int xp;

	/** The title which the dueler has */
	private String currentStage;

	/** Whether the dueler is alive or not */
	private boolean isAlive;
	
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


	/**
	 * Calls dueler to attack another dueler
	 * 
	 * @param dueler
	 *            - the dueler to be attacked
	 * */
	public abstract void attack(Dueler dueler);


	@Override
	public String toString() {
		return (this.currentStage + " " + this.name + ": HP - "
				+ this.currentHP + "MaxHP - " + this.maxHP + " XP - " + xp);
	}

}
