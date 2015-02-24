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
		this.name = "Lancelot";
	}
	
	@Override
	public void advanceLevel() {
		switch (currentStage) {
			case "Page" :
				currentStage = secondStage;
				currentAttack = secondAttack;
				currentDamage = secondDamage;
				xp = 0;
				break;
			case "Squire" :
				currentStage = thirdStage;
				currentAttack = thirdAttack;
				currentDamage = thirdDamage;
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
		dueler.subHP(currentDamage - 20);
	}

	@Override
	public void attack(PureDueler dueler) {
		dueler.subHP(currentDamage);
	}

	@Override
	public void attack(RoyalDueler dueler) {
		dueler.subHP(currentDamage + 20);
	}

}
