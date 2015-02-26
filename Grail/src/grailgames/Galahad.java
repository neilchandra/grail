package grailgames;

public class Galahad extends PureDueler {
	
	//stages
	private final String firstStage = "Page";
	private final String secondStage = "Squire";
	private final String thirdStage = "Knight";
	
	//attacks
	private final String firstAttack = "Chivalrous Cut";
	private final String secondAttack = "Gallant Gash";
	private final String thirdAttack = "Punch of Purity";
	
	//damage
	private final int firstDamage = 20;
	private final int secondDamage = 30;
	private final int thirdDamage = 60;
	
	//hp limits
	private final int firstMaxHP = 60;
	private final int secondMaxHP = 90;
	private final int thirdMaxHP = 120;


	public Galahad() {
		name = "Galahad";
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

	@Override
	public void attack(BraveDueler dueler) {
		dueler.subHP(currentDamage);
	}

	@Override
	public void attack(CowardlyDueler dueler) {
		dueler.subHP(currentDamage + 20);
	}

	@Override
	public void attack(PureDueler dueler) {
		dueler.subHP(currentDamage);
	}

	@Override
	public void attack(RoyalDueler dueler) {
		dueler.subHP(currentDamage - 20);
	}
}