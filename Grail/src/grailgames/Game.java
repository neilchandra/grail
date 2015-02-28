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

	/**
	 * Constructor which takes in command line arguments and runs game
	 * 
	 * @param args
	 *            - an array containing player and deck file names
	 */
	public Game(String[] args) {
		// Call to test Dueler Class
		// testDuelerMethod();

		// Stores command line arguments, if they are proper,
		// ends game otherwise
		if (args.length == 4) {
			playerNames[0] = args[0];
			playerNames[1] = args[2];
			deckFileNames[0] = args[1];
			deckFileNames[1] = args[3];
		} else {
			System.out
					.println("Usage: grailgames.Game <Player 1 Name> <Deck 1> <Player 2 Name> <Deck 2>");
			endGame();
		}
	}
	
	/**
	 * Runs the actually play
	 * 
	 * @throws IOException - if an error occurs in the buffered reader
	 */
	public void playGame() throws IOException {

		// Print opening to game
		System.out.println("Welcome to the Grail Games!");

		// Creates variables for decks
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

		// Set player 1 to start first
		currentPlayer = p1;
		otherPlayer = p2;

		// Opening game introduction
		System.out.println("Welcome to the Arena!");
		System.out.println(p1.getName() + " vs. " + p2.getName());
		System.out.println("Let the games begin!");

		// Each player starts with 6 cards
		for (int i = 0; i < 6; i++) {
			p1.drawCard();
			p2.drawCard();
		}

		// Announce first player's turn
		System.out.println();
		System.out.println(currentPlayer.getName() + "'s turn!");

		// Initial card draw when player's turn
		currentPlayer.drawCard();

		// Loop that runs game until finished
		while (true) {

			// Read command in and break in words
			String command = user.readLine();

			if(command == null){ 
				System.out.println("Goodbye!");
				endGame();
			}


			// Break command into parts
			String[] brokenCommand = command.trim().split(" ");

			// Perform action based on command
			if (brokenCommand.length > 2) {
				System.out.println("Please input one of the following: "
						+ " 'print field', 'print hand', 'attack', 'switch #',"
						+ " 'play #', or 'pass'");
			} else {

				if (brokenCommand[0].equals("print")
						&& brokenCommand.length == 2) {
					// Catches for print field and print hand commands
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
					if(currentPlayer.field[0] != null) {
						if (currentPlayer.field[0].getXP() > 0) {
							if (otherPlayer.field[0] == null) {
								System.out
										.println("Game over!  "
												+ currentPlayer.getName()
												+ " has mercilessly conquered the pitiful "
												+ otherPlayer.getName() + "!");
								endGame();
							} else { // both filled
								currentPlayer.field[0]
										.attack(otherPlayer.field[0]);
								switchTurn();
							}
						} else {
							System.out.println(currentPlayer.field[0].getName()
									+ " is not experienced enough yet to attack!");
							switchTurn();
						}	
					} else {
						System.out.println("No Dueler in battle position.");
						switchTurn();
					}
					
					
					
					// Catches for attack


				} else if (brokenCommand[0].equals("switch")
						&& brokenCommand.length == 2) {
					// Catches for switch command
					try {
						Integer i = Integer.parseInt(brokenCommand[1]);
						if (i >= 0 && i < 7) {
							currentPlayer.switchDueler(i);
						} else {
							System.out
									.println("Invalid input! Please input one of the following commands: "
											+ " 'print field', 'print hand', 'attack', 'switch #',"
											+ " 'play #', or 'pass'");
						}
					} catch (NumberFormatException e) {
						System.out
								.println("Invalid input! Please input one of the following commands: "
										+ " 'print field', 'print hand', 'attack', 'switch #',"
										+ " 'play #', or 'pass'");
					}
				} else if (brokenCommand[0].equals("play")
						&& brokenCommand.length == 2) {
					// Catches for play command
					try {
						int tempCard = Integer.parseInt(brokenCommand[1]) - 1;
						currentCard = tempCard;
						if (currentCard < currentPlayer.hand.size()
								&& currentCard >= 0) {
							// Code that calls the appropriate play method for
							// that Card
							currentPlayer.hand.get(currentCard).play(this);
							currentPlayer.hand.remove(tempCard);
						} else {
							System.out
									.println("This isn't a valid card number.");
						}
					} catch (NumberFormatException e) {
						System.out
								.println("The 'play' must be followed be the number of the card!");
					}
				} else if (brokenCommand[0].equals("pass")) {
					// Catches for pass command
					switchTurn();
				} else if (brokenCommand[0].equals("crash")
						&& brokenCommand.length == 1) {
					// Catches for crash commannd
					System.exit(1);
				} else {
					System.out
							.println("Invalid input! Please input one of the following commands: "
									+ " 'print field', 'print hand', 'attack', 'switch #',"
									+ " 'play #', or 'pass'");
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
				deck.add(new BoyArthur());
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

	/**
	 * Switches who the current player is and increases XP of dueler on field
	 * and new current player draws card
	 */
	public void switchTurn() {
		// Check if your dueler is still alive
		if (otherPlayer.field[0] != null && !otherPlayer.field[0].isAlive()) {
			System.out
					.println(otherPlayer.field[0].getName() + " has fainted!");
			otherPlayer.field[0] = null;
		}

		// Raises hp of others if Knight Galahad
		if (otherPlayer.field[0] != null
				&& otherPlayer.field[0].isEnhancesOthers()) {
			for (int i = 1; i < otherPlayer.field.length; i++) {
				if (otherPlayer.field[i] != null) {
					otherPlayer.field[i].addHP(5);

				}
			}
		}

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
	 * Test the method's for Duelers
	 */
	public void testDuelerMethod() {
		// Create an instances for testing
		PageRobin robin = new PageRobin();
		CCConcorde concorde = new CCConcorde(0);
		KnightGalahad galahad = new KnightGalahad(0);

		// Testing methods that modify HP
		System.out.println(robin.getName().equals("Page Robin"));
		System.out.println(robin.getHP() == 60);
		System.out.println(robin.getMaxHP() == 60);
		robin.subHP(20);
		System.out.println(robin.getHP() == 40);
		System.out.println(robin.getMaxHP() == 60);
		robin.addHP(10);
		System.out.println(robin.getHP() == 50);
		robin.addMaxHP(20);
		System.out.println(robin.getMaxHP() == 80);
		robin.addHP(5000);
		System.out.println(robin.getHP() == 80);
		System.out.println(robin.getMaxHP() == 80);
		robin.depleteHP();
		System.out.println(robin.getHP() == 0);
		robin.restoreHealth();
		System.out.println(robin.getHP() == 80);
		robin.depleteHP();
		robin.subHP(30);
		System.out.println(robin.isAlive() == false);

		// Testing methods that modify XP
		System.out.println(concorde.getXP() == 0);
		concorde.addOneXP();
		concorde.addOneXP();
		concorde.addOneXP();
		System.out.println(concorde.getXP() == 3);
		concorde.xpToZero();
		System.out.println(concorde.getXP() == 0);

		// Testing methods that modify arena XP
		System.out.println(concorde.getArenaXP() == 0);
		concorde.addOneArenaXP();
		concorde.addOneArenaXP();
		concorde.addOneArenaXP();
		concorde.addOneArenaXP();
		System.out.println(concorde.getArenaXP() == 4);
		concorde.restartArenaXP();
		System.out.println(concorde.getArenaXP() == 0);
		System.out.println(concorde.isEnhancesOthers() == false);
		System.out.println(concorde.toString().equals(
				"CC Concorde: 70/70  Attack power: 30  XP: 0"));

		// Testing other methods
		System.out.println(galahad.isEnhancesOthers() == true);
		System.out.println(galahad.isAlive() == true);

		// Exile test instances
		concorde.exile();
		galahad.exile();
		System.out.println(concorde.isAlive() == false);
		System.out.println(galahad.isAlive() == false);
	}

	/** 
	 * Purpose is to run the games
	 */
	public static void main(String[] args) {
		Game g = new Game(args);
		// Starts gameplay
		try {
			g.playGame();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException: game unable to start");
		}
	}
}
