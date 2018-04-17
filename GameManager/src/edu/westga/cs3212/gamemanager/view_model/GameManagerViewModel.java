package edu.westga.cs3212.gamemanager.view_model;

import java.util.ArrayList;
import java.util.Random;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;
import edu.westga.cs3212.gamemanager.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * GameManager View-model that manages players and implementations of the game
 * such as save game, progress. and adding players, etc
 * 
 * @author Dallas, Josh, Caleb, Bryan
 * @version 2/13/2018
 *
 */
public class GameManagerViewModel {

	private ObservableList<Game> completedGames;
	private ObservableList<Game> inProgressGames;
	private User theUser;
	private ObservableList<Player> playersInCurrentGame;

	/**
	 * Constructor for the game manager class
	 * 
	 * @preconditions: none
	 * @postconditions: private variables are instantiated.
	 * 
	 */
	public GameManagerViewModel() {
		this.theUser = new User("Name");
		this.populateUserWithGames();
		this.inProgressGames = FXCollections.observableList(this.theUser.getInProgressGames());
		this.completedGames = FXCollections.observableList(this.theUser.getCompletedGames());
		this.playersInCurrentGame = FXCollections.observableList(this.theUser.getCurrentGame().getPlayers());
	}

	/**
	 * Clears players in current game
	 * 
	 * @precondition: none
	 * @postcondition: playersInCurrentGame is cleared
	 */
	public void clearPlayersInCurrentGame() {
		this.playersInCurrentGame = FXCollections.observableList(new ArrayList<Player>());
	}

	private void populateUserWithGames() {
		for (int i = 0; i < 10; i++) {
			Game newGame = new Game("GAME" + i);
			Random random = new Random();
			for (int j = 0; j < (random.nextInt(7) + 1); j++) {
				newGame.addPlayer(new Player("PLAYER" + j, random.nextInt(100)));
			}
			this.theUser.addInProgressGame(newGame);
		}
		for (int i = 0; i < 10; i++) {
			Game newGame = new Game("COMPLETEDGAME" + i);
			Random random = new Random();
			for (int j = 0; j < (random.nextInt(7) + 1); j++) {
				newGame.addPlayer(new Player("PLAYER" + j, random.nextInt(100)));
			}
			newGame.setCompleteStatus(true);
			this.theUser.addCompletedGame(newGame);
		}
	}

	/**
	 * Returns a list of completed games
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return returns a list containing the number of completed games or an empty
	 *         list of completed games.
	 */
	public ObservableList<Game> getCompletedGames() {
		this.completedGames = FXCollections.observableList(this.theUser.getCompletedGames());
		return this.completedGames;
	}

	/**
	 * Sets the players In Current Game to param value
	 * 
	 * @precondition: playersInCurrentGame != null
	 * @postcondition: this.playersInCurrentGame is set to param value
	 * 
	 * @param playersInCurrentGame
	 *            list of in players in games
	 */
	public void setPlayersInCurrentGame(ObservableList<Player> playersInCurrentGame) {
		if (playersInCurrentGame == null) {
			throw new IllegalArgumentException("List must exist");
		}
		this.playersInCurrentGame = playersInCurrentGame;
	}

	/**
	 * returns a observable list of games in progress
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * @return a observable list of games in progress
	 */
	public ObservableList<Game> getInProgressGames() {
		this.inProgressGames = FXCollections.observableList(this.theUser.getInProgressGames());
		return this.inProgressGames;
	}

	/**
	 * returns the user
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return the user
	 */
	public User getTheUser() {
		return this.theUser;
	}
	
	public void setTheUser(User newUser) {
		this.theUser = newUser;
	}

	/**
	 * Returns players in current game
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return players in current game
	 */
	/**
	 * public ObservableList<Player> getPlayersInCurrentGame() {
	 * this.playersInCurrentGame =
	 * FXCollections.observableList(this.theUser.getCurrentGame().getPlayers());
	 * return this.playersInCurrentGame; }
	 **/
	public ObservableList<Player> getPlayersInCurrentGame() {
		return this.playersInCurrentGame;
	}

	/**
	 * Adds player to current game
	 * 
	 * @precondition: newPlayer != null
	 * @postcondition: player is added
	 * @param newPlayer
	 *            player to add
	 */
	public void addPlayersToCurrentGame(Player newPlayer) {
		if (newPlayer == null) {
			throw new IllegalArgumentException("Player is null");
		}
		this.playersInCurrentGame.add(newPlayer);
	}

	/**
	 * Saves the current game
	 * 
	 * @precondition: none
	 * @postcondition: current game is saved.
	 */
	public void saveCurrentGame() {
		this.playersInCurrentGame = FXCollections.observableList(this.theUser.getCurrentGame().getPlayers());
		Object[] players = this.playersInCurrentGame.toArray();
		ArrayList<Player> playerList = new ArrayList<Player>();
		for (int i = 0; i < players.length; i++) {
			playerList.add((Player) players[i]);
		}
		String gameName = this.theUser.getCurrentGame().toString();
		Game theOldCurrentGame = new Game(gameName);
		for (Player currPlayer : playerList) {
			theOldCurrentGame.addPlayer(currPlayer);
		}
		int removalIndex = 55;
		int counter = 0;
		for (Game currGame : this.theUser.getInProgressGames()) {
			if (currGame == this.theUser.getCurrentGame()) {
				removalIndex = counter;
			}
			counter++;
		}
		if (removalIndex != 55) {
			this.theUser.getInProgressGames().remove(removalIndex);
			this.theUser.addInProgressGame(theOldCurrentGame);
		}
		
	}

}
