package grailgames;

public class Lancelot extends BraveDueler {

	//stages
	private final String firstStage = "Page";
	private final String secondStage = "Squire";
	private final String thirdStage = "Knight";
	
	//attacks
	private final String firstAttack = "Punch of Fury";
	private final String secondAttack = "Sword Stab";
	private final String thirdAttack = "Mighty Joust";
	
	//damage
	private final int firstDamage = 20;
	private final int secondDamage = 30;
	private final int thirdDamage = 50;
	
	//hp limits
	private final int firstMaxHP = 60;
	private final int secondMaxHP = 100;
	private final int thirdMaxHP = 140;


	public Lancelot() {
		name = "Lancelot";
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
				addHP(secondMaxHP - firstMaxHP);
				maxHP = secondMaxHP;
				xp = 0;
				break;
			case "Squire" :
				currentStage = thirdStage;
				currentAttack = thirdAttack;
				currentDamage = thirdDamage;
				maxHP = thirdMaxHP;
				addHP(secondMaxHP - firstMaxHP);
				xp = 0;
				break;
			default :
				//do nothing
				break;
		}
	}

}
