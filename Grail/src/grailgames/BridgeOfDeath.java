package grailgames;

public class BridgeOfDeath  extends TrainingCard  {

	public BridgeOfDeath() {
		name = "Bridge of Death";
	}
	/*
	@Override
	public void play(Game c) {
		System.out.println("Select a Dueler:");
		System.out.println("0 for the battling Duelers, 1-6 for the bench");
		try {
			String lineUser = user.readLine();
			if(lineUser.equals("")){
				System.out.println("Invalid input!  Please try again:");
				play(c);
			} else {
				String [] words = lineUser.split(" ");
				int index = Integer.parseInt(words[0]); 
				//it works if it reaches here
				if(index >= 0 && index < 7) {
					//do work of training card
					Dueler [] duelers = c.otherPlayer.field;
					if(duelers[index] == null) {
						System.out.println("No effect.");
					} else { //dueler in index to be switched with
						Dueler d = duelers[0];
						duelers[0] = duelers[index];
						duelers[index] = d;
					}
					
				} else {
					System.out.println("Invalid input!  Please try again:");
					play(c);
				}
			}
		} catch(Exception e) {
			System.out.println("Invalid input!  Please try again:");
			play(c);
		}
	}
	
	*/
	@Override
	public void actUpon(Game game, int duelerIndex) {
		if (game.otherPlayer.field[duelerIndex] == null) {
			System.out.println("No effect.");
		} else { // dueler in index to be switched with
			Dueler d = game.otherPlayer.field[0];
			game.otherPlayer.field[0] = game.otherPlayer.field[duelerIndex];
			game.otherPlayer.field[duelerIndex] = d;
			System.out.println(game.otherPlayer.field[0].getName() + " was moved to the arena!");
			System.out.println(game.otherPlayer.field[duelerIndex].getName() + " was moved to the field!");
			game.otherPlayer.field[0].restartArenaXP();
			game.otherPlayer.field[duelerIndex].restartArenaXP();
		}
	}
}

