package grailgames;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Camelot {

	// variable declaration

	// players
	Player p1, p2, currentPlayer, otherPlayer;

	// deck files
	String [] deckFileNames;
	String [] playerNames;
	// Buffered reader for user input
	BufferedReader user;
	// variable for current card called
	Integer currentCard = null;
	
	public Camelot() {
		try {
			playGame();
		} catch (IOException e) {
			System.out.println("IOException: game unable to start");
		}
	}

	public void playGame() throws IOException {
		
		//welcome to the game
		System.out.println("Welcome to the Grail Games!");
		
		// initialize game
		deckFileNames = new String[2];
		playerNames = new String[2];

		user = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 3; i++) {
			System.out.println("Input the name of Deck " + i + ":");
			String lineUser = user.readLine();
			while (lineUser == null) { // in case of no input
				System.out.println("Please input a file name!");
			}
			deckFileNames[i - 1] = lineUser;
		}
		for (int i = 1; i <= 3; i++) {
			System.out.println("Input the name of Player " + i + ":");
			String lineUser = user.readLine();
			while (lineUser == null) { // in case of no input
				System.out.println("Please input a Player name!");
			}
			playerNames[i - 1] = lineUser;
		}

		// getDecks using deckGetter
		ArrayList<Card> player1Deck = buildDeck(GrailIO
				.getDeck(deckFileNames[0]));
		ArrayList<Card> player2Deck = buildDeck(GrailIO
				.getDeck(deckFileNames[1]));
		
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
		
		
		
		
		
		while(!isGameOver()) {
			// Announce which player's turn it is
			System.out.println(currentPlayer.getName() + " it's your turn!");
			
			// Read command in and break in words 
			String command = read.readLine();
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
						// Code that calls the appropiate play method for that Card
						currentPlayer.hand.get(cardNumber).play(this);
					} else {
						System.out.println("The number for this card do not exist in your hand. Please enter a valid card number.");
					}
				}

				
				
				if(brokenCommand[0].equals("pass")) {
					Player temp = currentPlayer;
					currentPlayer = otherPlayer;
					otherPlayer = temp;
					System.out.println(currentPlayer.getName() + "s turn.");
				}
				
			}
			
			for(Dueler d : currentPlayer.field) {
				d.addOneXP();
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
				deck.add(new Robin());
				break;
			case "Peasant Merek":
				deck.add(new Merek());
				break;
			case "Page Lancelot":
				deck.add(new Lancelot());
				break;
			case "Peasant Concorde":
				deck.add(new Concorde());
				break;
			case "Page Galahad":
				deck.add(new Galahad());
				break;
			case "Peasant Rowan":
				deck.add(new Rowan());
				break;
			case "Boy Arthur":
				deck.add(new Robin());
				break;
			case "Peasant Patsy":
				deck.add(new Patsy());
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

	
	public static void main(String[] args) {
		Camelot c = new Camelot();
	}
	
}
