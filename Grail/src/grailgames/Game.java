package grailgames;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Game {

	// variable declaration

	// players
	Player p1, p2, currentPlayer, otherPlayer;


	// deck files
	String [] deckFileNames = new String [2];
	String [] playerNames = new String [2];
	// Buffered reader for user input
	BufferedReader user  = new BufferedReader(new InputStreamReader(System.in));
	// variable for current card called
	Integer currentCard = null;
	
	public Game(String[] args) {

		
		if(args.length == 4){
			playerNames[0] = args[0];
			playerNames[1] = args[2];
			deckFileNames[0] = args[1];
			deckFileNames[1] = args[3];
			
			
			
		} else {
			System.out.println("Usage: grailgames.Game <Player 1 Name> <Deck 1> <Player 2 Name> <Deck 2>");
			System.exit(1);
		}
		
		try {
			playGame();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException: game unable to start");
		}
	}

	public void playGame() throws IOException {
		
		//welcome to the game
		System.out.println("Welcome to the Grail Games!");
		
		ArrayList<Card> player1Deck;
		ArrayList<Card> player2Deck;
		
		try{
			player1Deck = buildDeck(GrailIO
					.getDeck(deckFileNames[0]));			
		} catch (IOException e) {
			player1Deck = new ArrayList<Card>(0);
		}
		
		try{
			player2Deck = buildDeck(GrailIO
					.getDeck(deckFileNames[1]));			
		} catch (IOException e) {
			player2Deck = new ArrayList<Card>(0);
		}
		
		//incase deck files are not found/empty
		if(player1Deck.isEmpty()){
			System.out.println("Deck file not found!");
		}
		if(player2Deck.isEmpty()) {
			System.out.println("Deck file not found!");
		}
		
		//instantiate player with decks
		p1 = new Player(playerNames[0], player1Deck);
		p2 = new Player(playerNames[1], player2Deck);
		currentPlayer = p1;
		otherPlayer = p2;

		// Opening game introduction
		System.out.println("Welcome to the Arena!");
		System.out.println(p1.getName() + " vs. " + p2.getName());
		System.out.println("Let the games begin!");	
		
		//draw 6 cards each
		for(int i=0; i<6; i++) {
			p1.drawCard();
			p2.drawCard();
		}
		
		
		//objective:
		//listen for commands
		//check legality of commands
		//do actions
		//switch turn if either attack or pass, i.e. switch players, increment counters etc.
	
		int x = 0; //temporary
		while(x == 0) { //change to game over condition
			//Announce player's turn
			System.out.println();
			System.out.println(currentPlayer.getName() + "it's your turn!");
			
			x++;
		}
		

	
		while(true) {
			
	

			// Read command in and break in words 
			String command = user.readLine();
			String[] brokenCommand = command.split(" ");
			
			// Perform action based on command
			if(brokenCommand.length > 2){
				System.out.println("Invalid input! Please input one of the following commands: 'print field', 'print hand', 'attack', 'switch [number]', 'play [number] or pass");
			} else {
				
				if(brokenCommand[0].equals("print")) {
					// Catches print field and calls method
					if(brokenCommand[1].equals("field")) {
						currentPlayer.printField();
						otherPlayer.printField();			
					}
					
					// Catches print hand and calls method
					if(brokenCommand[1].equals("hand")) {
						currentPlayer.printHand();
					}	
				}
				
				
				if(brokenCommand[0].equals("attack")) {
					currentPlayer.field[0].attack(otherPlayer.field[0]);
				}
				
				
				if(brokenCommand[0].equals("switch")) {
					currentPlayer.switchDueler(Integer.parseInt(brokenCommand[1]));
				}
				
				
				if(brokenCommand[0].equals("play")) {
					// Parse command and 
					int cardNumber = Integer.parseInt(brokenCommand[1]) - 1;
					
					if(cardNumber < currentPlayer.hand.size() && cardNumber > 0) {
						// Code that calls the appropriate play method for that Card
						currentPlayer.hand.get(cardNumber).play(this);
					} else {
						System.out.println("This isn't a valid card number.");
					}
				}

				
				
				if(brokenCommand[0].equals("pass")) {
					Player temp = currentPlayer;
					currentPlayer = otherPlayer;
					otherPlayer = temp;
					System.out.println(currentPlayer.getName() + " it's your turn!");
				}
				
			}
			
			for(Dueler d : currentPlayer.field) {
				if(d != null) {
					d.addOneXP();
				}
			}
		
		}	


	}


	/**
	 * Reads Deck file and constructs the deck, an arraylist of cards
	 * 
	 * @param cards
	 *            - an array of strings containing Duelers and Training Cards
	 * @return - an arraylist of cards representing the deck
	 */
	public ArrayList<Card> buildDeck(String[] cards) {

		// define a card arraylist
		ArrayList<Card> deck = new ArrayList<Card>(0);

		// iterate through array of names
		for (String name : cards) {
			switch (name) {
			case "Anthrax Asylum":
				deck.add(new AnthraxAsylum());
				break;
			case "Brave Health":
				deck.add(new BraveHolyHealthPotion());
				break;
			case "Cowardly Health":
				deck.add(new CowardlyHolyHealthPotion());
				break;
			case "Pure Health":
				deck.add(new PureHolyHealthPotion());
				break;
			case "Royal Health":
				deck.add(new RoyalHolyHealthPotion());
				break;
			case "Camelot Reinforcements":
				deck.add(new CamelotReinforcements());
				break;
			case "Jousting Practice":
				deck.add(new JoustingPractice());
				break;
			case "Status Advance":
				deck.add(new StatusAdvance());
				break;
			case "Page Robin":
				deck.add(new PageRobin());
				break;
			case "Peasant Merek":
				deck.add(new PeasantMerek());
				break;
			case "Page Lancelot":
				deck.add(new PageLancelot());
				break;
			case "Peasant Concorde":
				deck.add(new PeasantConcorde());
				break;
			case "Page Galahad":
				deck.add(new PageGalahad());
				break;
			case "Peasant Rowan":
				deck.add(new PeasantRowan());
				break;
			case "Boy Arthur":
				deck.add(new PageRobin());
				break;
			case "Peasant Patsy":
				deck.add(new PeasantPatsy());
				break;
			case "Bridge of Death":
				deck.add(new BridgeOfDeath());
				break;
			default:
				// do nothing
				break;
			}

		} // end of for each loop

		return deck;
	}

	// Read in Decks
	// Randomize Cards and Make Decks
	// Make Player 1 draw 7 Cards from deck and move them into hand
	// Make Player 1 draw 7 Cards from deck and move them into hand

	// INSIDE LOOP
	// State that it is player one's Turn
	// wait for command
	// request more information if needed
	// check if game is over
	// repeat loop

	/*
	 * command = read.readLine(); if(command == "play") { System.out.println();
	 * }
	 */

	// Camelot will use Double Dispatch on play method
	// one for Duelers, ActUpon, HolyHealthPotion and CamelotReinforcement
	// Camelot has access to player's hand and field
	// The number of card will be parse then use get([number]) to get card from
	// hand

	// If Dueler card is played
	public void play(int duelerIndex) {
		currentPlayer.addDuelerToField(duelerIndex);
	}

	// Prompts for a Dueler 
	/*
	public Dueler promptForDueler() {
		System.out.println("Select a Dueler:");
		System.out.println("0 for the battling Duelers, 1-6 for the bench");
		try {
			String lineUser = user.readLine();
			if(lineUser.equals("")){
				System.out.println("Invalid input!  Please try again:");
				promptForDueler();
			} else {
				String [] words = lineUser.split(" ");
				int index = Integer.parseInt(words[0]); 
				//it works if it reaches here
				if(index >= 0 && index < 7) {
					//do work of training card
					Dueler [] duelers = currentPlayer.field;
					if(duelers[index] == null) {
						System.out.println("No effect.");
					} else {
						actUpon(duelers[index]);
					}
					
				} else {
					System.out.println("Invalid input!  Please try again:");
					promptForDueler();
				}
			}
		} catch(Exception e) {
			System.out.println("Invalid input!  Please try again:");
			play(c);
		}	
	}
	*/
	public static void main(String[] args) {

		Game g = new Game(args);


	}

}
