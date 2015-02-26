package grailgames;

public class Rowan extends PureDueler {

	//stages
	private final String firstStage = "Peasant";
	private final String secondStage = "CC";
	
	//attacks
	private final String firstAttack = "Roundhouse Kick";
	private final String secondAttack = "Rowan's Rampage";
	
	//damage
	private final int firstDamage = 20;
	private final int secondDamage = 40;
	
	//hp limits
	private final int firstMaxHP = 80;
	private final int secondMaxHP = 100;


	public Rowan () {
		name = "Rowan";
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
