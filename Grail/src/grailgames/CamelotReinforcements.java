package grailgames;

public class CamelotReinforcements extends TrainingCard {

	@Override
	public void play(Game c) {
		System.out.println(c.currentPlayer.getName()+" used Camelot Reinforcements!");
		c.currentPlayer.drawCard();
		c.currentPlayer.drawCard();
		c.currentPlayer.drawCard();
	}

	@Override
	public void actUpon(Game game, int duelerIndex) {
		//not needed
	}
	
	public CamelotReinforcements() {
		name = "Camelot Reinforcements";
	}
}
