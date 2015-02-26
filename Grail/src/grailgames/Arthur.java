package grailgames;

public class Arthur extends RoyalDueler {

	//stages
	private final String firstStage = "Boy";
	private final String secondStage = "Prince";
	private final String thirdStage = "King";
	
	//attacks
	private final String firstAttack = "Royal Charm";
	private final String secondAttack = "Trivia Tackle";
	private final String thirdAttack = "Excalibur";
	
	//damage
	private final int firstDamage = 20;
	private final int secondDamage = 40;
	private final int thirdDamage = 50;
	
	//hp limits
	private final int firstMaxHP = 80;
	private final int secondMaxHP = 120;
	private final int thirdMaxHP = 160;


	public Arthur() {
		name = "Arthur";
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
			case "Squire" :
				currentStage = thirdStage;
				currentAttack = thirdAttack;
				currentDamage = thirdDamage;
				maxHP = thirdMaxHP;
				addHP(thirdMaxHP - secondMaxHP);
				xp = 0;
				break;
			default :
				//do nothing
				break;
		}
	}

}
