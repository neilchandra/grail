package grailgames;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class TrainingCard extends Card{
	
	BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
	
	/** Performs the card action upon a dueler */
	public abstract void actUpon(Game game, int duelerIndex);
	
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
					System.out.println(c.currentPlayer.getName() + " used " + getName() + "!");
					actUpon(c, index);
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
	public String toString() {
		return this.name;
	}
	
	
	
	@Override
	public String getName() {
		return (name);	
	}
}
