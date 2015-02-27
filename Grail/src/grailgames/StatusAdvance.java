package grailgames;

public class StatusAdvance extends TrainingCard {

	@Override
	public void actUpon(Dueler dueler) {
		if(dueler.getXP() >= 3) {
			dueler = dueler.advanceLevel();	
		}
	}
	
	
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
					System.out.println(c.currentPlayer.getName()+" used Status Advance.");
					//do work of training card
					Dueler [] duelers = c.currentPlayer.field;
					if(duelers[index] == null) {
						System.out.println("No effect.");
					} else {
						if(duelers[index].getXP() >= 3) {
							duelers[index] = duelers[index].advanceLevel();	
						}
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
	
	public StatusAdvance() {
		name = "Status Advance";
	}
}
