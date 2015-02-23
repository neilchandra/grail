package grailgames;

public abstract class Dueler extends Card implements Advanceable {
//to be implemented, just here for coding purposes
	
	/** The maximum health the dueler can have */
	private int maxHP;
	
	/** The current value of the dueler's HP */
	private int currentHP;
	
	/** The experience a dueler has in combat */
	private int xp;
	
	/** The title which the dueler has */
	private String stage; 
	
	public void addHP(int increment) {
		currentHP += increment;
	}
	
	public void subHP(int decrement) {
		currentHP -= decrement;
	}
	
	public void addMaxHP(int increment) {
		maxHP += increment;
	}
	
	/** Calls dueler to attack another dueler 
	 * @param dueler - the dueler to be attacked
	 * */
	public abstract void attack(Dueler dueler);
	
	
	@Override 
	public String toString() {
		return new String(stage + " " + this.name + ": HP - " + currentHP + " MaxHP - " + maxHP + " XP - " + xp);
	}

}
