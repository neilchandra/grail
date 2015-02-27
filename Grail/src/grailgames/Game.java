package grailgames;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

	/** Variables to represent players */
	Player p1, p2, currentPlayer, otherPlayer;

	
	/** Arrays to store deck and player names */
	String[] deckFileNames = new String[2];
	String[] playerNames = new String[2];
	

	/** Variable for current card called/played */
	Integer currentCard = null;
	
	
	/** Buffered reader for user input */
	BufferedReader user = new BufferedReader(new InputStreamReader(System.in));

	
	public Game(String[] args) {
		// Stores commandline arguments
		if (args.length == 4) {
			playerNames[0] = args[0];
			playerNames[1] = args[2];
			deckFileNames[0] = args[1];
			deckFileNames[1] = args[3];

		} else {
			System.out
					.println("Usage: grailgames.Game <Player 1 Name> <Deck 1> <Player 2 Name> <Deck 2>");
			System.exit(1);
		}

		
		// Starts gameplay
		try {
			playGame();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException: game unable to start");
		}
	}

	public void playGame() throws IOException {

		// Welcome to the game
		System.out.println("Welcome to the Grail Games!");

		
		ArrayList<Card> player1Deck;
		ArrayList<Card> player2Deck;
		
		
		// Builds decks for players
		try {
			player1Deck = buildDeck(GrailIO.getDeck(deckFileNames[0]));
		} catch (IOException e) {
			player1Deck = new ArrayList<Card>(0);
		}

		try {
			player2Deck = buildDeck(GrailIO.getDeck(deckFileNames[1]));
		} catch (IOException e) {
			player2Deck = new ArrayList<Card>(0);
		}

		
		// Messages printed if decks can not be found
		if (player1Deck.isEmpty()) {
			System.out.println("Deck file not found!");
		}
		if (player2Deck.isEmpty()) {
			System.out.println("Deck file not found!");
		}

		// Instantiate player and give them decks
		p1 = new Player(playerNames[0], player1Deck);
		p2 = new Player(playerNames[1], player2Deck);
		currentPlayer = p1;
		otherPlayer = p2;

		// Opening game introduction
		System.out.println("Welcome to the Arena!");
		System.out.println(p1.getName() + " vs. " + p2.getName());
		System.out.println("Let the games begin!");

		// Each player draws 6 cards each and puts them in their hands
		for (int i = 0; i < 6; i++) {
			p1.drawCard();
			p2.drawCard();
		}

		
		// Announce first player and do initial drawing of card at start of game
		System.out.println();
		System.out.println(currentPlayer.getName() + "'s turn!");
		currentPlayer.drawCard();
		
		// Loop that runs game until finished
		while (true) {

			// Read command in and break in words
			String command = user.readLine().trim();
			String[] brokenCommand = command.split(" ");

			// Perform action based on command
			if (brokenCommand.length > 2) {
				System.out
						.println("Invalid input! Please input one of the following commands: "
								+ " 'print field', 'print hand', 'attack', 'switch #',"
								+ " 'play #', or 'pass'");
			} else {

				if (brokenCommand[0].equals("print") && brokenCommand.length == 2) {
					// Catches print field and calls method
					if (brokenCommand[1].equals("field")) {
						currentPlayer.printField();
						otherPlayer.printField();
					} else if (brokenCommand[1].equals("hand")) {
						currentPlayer.printHand();
					} else {
						System.out
						.println("Invalid input! Please input one of the following commands: "
								+ " 'print field', 'print hand', 'attack', 'switch #',"
								+ " 'play #', or 'pass'");
					}
				} else if (brokenCommand[0].equals("attack")) {
					
					// THE IF STATEMENT HAD GETARENAXP CHANGED TO GETXP 
					if (currentPlayer.field[0].getXP() > 0) {
						if (currentPlayer.field[0] != null) {
							if (otherPlayer.field[0] == null) {
								System.out
										.println("Game over!  "
												+ currentPlayer.getName()
												+ " has mercilessly conquered the pitiful "
												+ otherPlayer.getName() + "!");
								endGame();
							} else { //both filled
								currentPlayer.field[0]
										.attack(otherPlayer.field[0]);
								switchTurn();
							}
						} else { //current player empty
							System.out.println("No Dueler in battle position.");
							switchTurn();
						}

					} else {
						System.out.println(currentPlayer.field[0].getName()
								+ " is not experienced enough yet to attack!");
						switchTurn();
					}

				} else if (brokenCommand[0].equals("switch")  && brokenCommand.length == 2) {
					currentPlayer.switchDueler(Integer
							.parseInt(brokenCommand[1]));
				} else if (brokenCommand[0].equals("play") && brokenCommand.length == 2) {
					// Parse command and
					try {
						int cardNumber = Integer.parseInt(brokenCommand[1]) - 1;
					
					currentCard = cardNumber;
					if (cardNumber < currentPlayer.hand.size()
							&& cardNumber >= 0) {
						// Code that calls the appropriate play method for that
						// Card
						currentPlayer.hand.get(cardNumber).play(this);
						currentPlayer.hand.remove(cardNumber);
						
					} else {
						System.out.println("This isn't a valid card number.");
					}
					} catch(NumberFormatException e) {
						System.out.println("The 'play' must be followed be the number of the card!");
					}
				} else if (brokenCommand[0].equals("pass")) {
					switchTurn();
				} else {
					System.out
							.println("Invalid input! Please input one of the following commands: "
									+ " 'print field', 'print hand', 'attack', 'switch [number]',"
									+ " 'play [number] or pass");
				}

			}

		}

	}

	/** Switches who the current player is and increases 
	 *  XP of dueler on field and new current player draws 
	 *  card
	 */
	public void switchTurn() {

		// Player's XP goes up every round they remain on the field
		for (Dueler d : otherPlayer.field) {
			if (d != null) {
				d.addOneXP();
			}
		}
		if (otherPlayer.field[0] != null) {
			otherPlayer.field[0].addOneArenaXP();
		}
		Player temp = currentPlayer;
		currentPlayer = otherPlayer;
		otherPlayer = temp;
		System.out.println(currentPlayer.getName() + "'s turn!");

		// Player draws card before it's their turn
		currentPlayer.drawCard();

	}

	/**
	 * Ends the game 
	 */
	public void endGame() {
		System.exit(1);
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

	/** Purpose is to run the games */
	public static void main(String[] args) {

		Game g = new Game(args);

	}

}
