package grailgames;

public class Concorde extends BraveDueler {

	//stages
	private final String firstStage = "Peasant";
	private final String secondStage = "CC";
	
	//attacks
	private final String firstAttack = "Brave Bite";
	private final String secondAttack = "Concorde's Conqueror";
	
	//damage
	private final int firstDamage = 30;
	private final int secondDamage = 30;
	
	//hp limits
	private final int firstMaxHP = 40;
	private final int secondMaxHP = 70;


	public Concorde() {
		name = "Concorde";
		isAlive = true;
		currentAttack = firstAttack;
		currentDamage = firstDamage;
		currentStage = firstStage;
		maxHP = firstMaxHP;
		currentHP = maxHP;
		xp = 0;
	}
	
	@Override
	public void advanceLevel() {
		switch (currentStage) {
			case "Page" :
				currentStage = secondStage;
				currentAttack = secondAttack;
				currentDamage = secondDamage;
				maxHP = secondMaxHP;
				addHP(secondMaxHP - firstMaxHP);
				xp = 0;
				break;
			default :
				//do nothing
				break;
		}
	}
}
