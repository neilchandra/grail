Welcome the Monty Python Battler!

Instructions

	How to Start the Game

		Navigate to the directory where the Game files are located and run the following command in your terminal: java grailgames.Game <Player 1 Name> <grailgames/[Player 1's Deck File Name]> java grailgames.Game <Player 2 Name> <grailgames/[Player 2's Deck File Name]>. Then press the "Enter" key and you're ready to play!


	Type of Card

		Dueler - These cards are your duelers which you use to battle with. They have a specific attack which may be an advantage or disadvantage based on who they attack. Every Dueler can advance their status acquiring a new attack, attack damage, status and HP.

										Robin               Merek

										Lancelot            Concorde

										Galahad             Rowan

										Arthur              Patsy

			* Dueler's have teams: Robin and Merek - Cowardly, Lancelot and Concorde - Brave, Galahad and Rowan - Pure, Arthur and Patsy - Royal


		Training Cards

			Anthrax Asylum: The choosen dueler regains all lost HP
			
			Holy Health Potion: There are three types of Holy Health Potions (Cowardly, Brave, Pure).
				Any potion may be used by any Dueler. If their team matches the card, the Dueler regains 30
				HP. If their team does not match, that Dueler regains only 10 HP
			
			Jousting Practice: Choose a Dueler. The max HP of that Dueler increases by 20. It also
				gains 20 HP
			
			Camelot Reinforcements: Draw three cards and add them to your hand
			
			Status Advance: Advances the selected dueler to its next status if it can

			Bridge of Death: Allows you to switch your opponent's dueler in the arena with one from their 		bench


	How to Play the Game

		So you're wondering how to play the game? Player's have a deck, a hand and a field. Your deck is shuffled and you draw from it without the ability of knowing which card you get. Your hand are the cards you have the ability to play. Lastly, your field is where your Duelers, who are ready to fight, live. Inside, your field you have an arena and a bench. Only the dueler in the arena attack and be attacked, all other dueler sit on the bench. So how do you perform actions? It's simply. Player's just type commmands into the terminal and, if the input, the action is performed, if not then a message will inform you of an error. Below is a list of the commands you can use:

			print field - Prints your field and the location of each dueler in it. If you have a Dueler in 	
				the position in the field, that dueler's status, name, HP, attack damage and XP will be displayed. If there is no Dueler in that position then that position will display "Empty".


			print hand - Prints your hand by displaying the name of every Card inside it.


			attack - Makes your dueler in your arena attack your opponent's dueler in their arena.


			switch [NUMBER] - Allows you to switch dueler's position in your field. For instance, if you 		wanted to swap your dueler in your arena with a dueler in your hand, called "switch" followed 	  by the locaiton of that dueler in your field.


			play [NUMBER] - Plays a card given the number of it in your hand. If you print your hand you can 	 the card's number. 


			pass - End's your turn and let's the other player take their turn.


Design Overview
	
	Our design is meant to break down the responsiblilty of the subclass

	Card (abstract) - the super class of all cards; contains 

			- Dueler(abstract) - super class for types of Dueler; 
				-> Cowardly Dueler
					o Page Robin
					o Squire Robin
					o Knight Robin
					o Peasant Merek
					o Minstrel Merek
				-> Brave Dueler
					o Page Lancelot
					o Squire Lancelot
					o Knight Lancelot
					o Peasant Concorde
					o CC Concorde
				-> Pure Dueler
					o Page Galahad
					o Squire Galahad
					o Knight Galahad
					o Peasant Rowan
					o CC Rowan
				-> Royal Dueler
					o Boy Arthur
					o Prince Arthur
					o King Arthur
					o Peasant Patsy
					o CC Patsy

			- TrainingCard(abstract) - super class for types of TrainingCards
				-> Anthrax Asylum
				-> Jousting Practice
				-> Camelot Reinforcements
				-> Status Advance 
				-> Holy Health Potion (abstract)
					o Pure Health
					o Brave Health
					o Cowardly Helath
					o Royal Health

	Player - the class for the players of the game

	Game - the game which the game is played


	How Program Functions

		The user types in one of the six valid commands into the terminal. The Game class then parses the input and performs the appropiate action. The 'print field' command calls the player's printField() method. The 'print hand' command calls the player's printhand() method. For the 'attack' command, Game calls the dueler's attach() method passing in the opponents dueler in the arena. The 'switch #' command call the player's switchDueler() method. The 'play #' command calls either the dueler's play(Game c) method in the Dueler class or calls the play(Game c) in the TrainingCard class. The 'pass' command calls the switchTurn() method contained in Game. Game is the main class where from which everything is run. All the other classes are subsidiaries.


 	*Note - If 'crash' is typed into terminal the game will terminate

	Any Possible Bugs: None

	Collaborators/Developers: Neil Chandra and Kevin Anderson

	Extra features: None



