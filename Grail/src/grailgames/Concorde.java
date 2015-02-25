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
		this.name = "Concorde";
		currentAttack = firstAttack;
		currentDamage = firstDamage;
		currentStage = firstStage;
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
