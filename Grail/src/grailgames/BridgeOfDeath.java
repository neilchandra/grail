package grailgames;

public class BridgeOfDeath  extends TrainingCard  {

	@Override
	public void play(Camelot c) {
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
	
	@Override
	public void actUpon(Dueler d) {
		//doesn't need to be implemented
		
	}

	
}
