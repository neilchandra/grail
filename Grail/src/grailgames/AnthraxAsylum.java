package grailgames;

public class AnthraxAsylum extends TrainingCard implements ActUponDueler {

	@Override
	public void actUpon(Dueler dueler) {
		// increase hp to max
		dueler.addHP(dueler.getMaxHP());			
		System.out.println(dueler.getName() + "'s health was fully restored");
	}


}
