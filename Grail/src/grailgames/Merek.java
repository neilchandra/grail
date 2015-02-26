package grailgames;

public class Merek extends CowardlyDueler {
	//stages
	private final String firstStage = "Peasant";
	private final String secondStage = "Minstrel";
	
	//attacks
	private final String firstAttack = "Ballad Bash";
	private final String secondAttack = "Lute Laceration";
	
	//damage
	private final int firstDamage = 0;
	private final int secondDamage = 50;
	
	//hp limits
	private final int firstMaxHP = 100;
	private final int secondMaxHP = 150;


	public Merek() {
		name = "Merek";
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
