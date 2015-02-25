package grailgames;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Camelot {
	
	public static void main(String[] args) {
	
		// Varibles for deck file name's 
		String player1DeckFileName;
		String player2DeckFileName;
		
		// Build Decks
		GrailIO deckGetter;
		ArrayList<Card> player1Deck = buildDeck(deckGetter.getDeck(player1DeckFileName));
		ArrayList<Card> player2Deck = buildDeck(deckGetter.getDeck(player2DeckFileName));
		
		// Instatniate players and give them decks
		Player currentPlayer;
		Player p1 = new Player("Player 1", player1Deck);
		Player p2 = new Player("Player 1", player2Deck);
		
		// Make player 1 start the game
		currentplayer = p1;
		
		// Readers to parse user input
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		while(!isGameOver()) {
			
		}
	}

	/** Reads Deck file and constructs decks 
	 * @param cards - a array where each index contains the name of each card
	 * @return - a complete deck with Cards
	 */
	public ArrayList<Card> buildDeck(String[] cards){
		ArrayList<Card> deck;
		for(String name : cards) {
			if(name == "Anthrax Asylum") {
				deck.add(new AnthraxAsylum());
			}
			if(name == "Brave Health") {
				deck.add(new BraveHolyHealthPotion());
			}
			if(name == "Cowardly Health") {
				deck.add(new CowardlyHolyHealthPotion());
			}
			if(name == "Pure Health") {
				deck.add(new PureHolyHealthPotion());
			}
			if(name == "Royal Health") {
				deck.add(new RoyalHolyHealthPotion());
			}
			if(name == "Camelot Reinforcement") {
				deck.add(new CamelotReinforcements());
			}
			if(name == "Jousting Practice") {
				deck.add(new JoustingPractice());
			}
			if(name == "Status Advance") {
				deck.add(new StatusAdvance());
			}
			if(name == "Page Robin") {
				deck.add(new Robin());
			}
			if(name == "Peasant Merek") {
				deck.add(new Merek());
			}
			if(name == "Page Lancelot") {
				deck.add(new Merek());
			}
			if(name == "Peasant Concorde") {
				deck.add(new Merek());
			}
			if(name == "Page Galahad") {
				deck.add(new Merek());
			}
			if(name == "Peasant Rowan") {
				deck.add(new Merek());
			}
		}
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
	
	
	
	command = read.readLine();
	if(command == "play") {
		System.out.println();
	}
	
	
	
	
	
	
	// Camelot will use Double Dispatch on play method
	// one for Duelers, ActUpon, HolyHealthPotion and CamelotReinforcement
	// Camelot has access to player's hand and field
	// The number of card will be parse then use get([number]) to get card from hand
	
	// If Dueler card is played
	public void play(int duelerIndex)  {
		currentPlayer.addDuelerToField(duelerIndex);
	}
	
	
	public void play(CamelotReinforcements cam)  {
		cam.actUpon(currentPlayer);
	}

	public void useCard(HolyHealthPotion hHP) {
		// prompt for the dueler, indicated by number from field
		
		hp.actUpon()
	}
}
