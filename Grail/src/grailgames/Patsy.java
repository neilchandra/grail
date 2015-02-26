package grailgames;

public class Patsy extends RoyalDueler {

	//stages
	private final String firstStage = "Peasant";
	private final String secondStage = "CC";
	
	//attacks
	private final String firstAttack = "Patsy Punch";
	private final String secondAttack = "Coconut Chuck";
	
	//damage
	private final int firstDamage = 30;
	private final int secondDamage = 50;
	
	//hp limits
	private final int firstMaxHP = 60;
	private final int secondMaxHP = 100;


	public Patsy() {
		name = "Patsy";
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
