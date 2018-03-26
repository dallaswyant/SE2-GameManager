package edu.westga.cs3212.gamemanager.model;

import java.util.ArrayList;

/**
 * User class
 * 
 * @author Caleb, Dallas, Bryan, Josh
 * @version 2/14/18
 */
public class User {
	private String username;
	private ArrayList<Game> completed;
	private ArrayList<Game> inProgress;
	private Game currentGame;

	/**
	 * Constructor for user
	 * 
	 * @precondition: username != null && username.isEmpty() != true
	 * @postcondition: username is set to param value
	 * 
	 * @param username
	 *            username of the user
	 */
	public User(String username) {
		if (username == null) {
			throw new IllegalArgumentException("Invalid username");
		}
		if (username.isEmpty()) {
			throw new IllegalArgumentException("Username not entered");
		}
		this.username = username;
		this.completed = new ArrayList<Game>();
		this.inProgress = new ArrayList<Game>();
		this.currentGame = new Game("Defualt Game Name");
	}

	/**
	 * Adds a game to the inProgress ArrayList
	 * 
	 * @precondition: game != null
	 * @postcondition: game is added to completed list
	 * 
	 * @param game
	 *            game to add to list
	 */
	public void addInProgressGame(Game game) {
		if (game == null) {
			throw new IllegalArgumentException("Game must exist");
		}

		if (this.inProgress.contains(game)) {
			this.inProgress.remove(game);
		}
		if (this.completed.contains(game)) {
			this.completed.remove(game);
		}

		if (game.getCompletedStatus()) {
			game.setCompleteStatus(false);
		}

		this.inProgress.add(game);
	}

	/**
	 * Adds game to the completed ArrayList
	 * 
	 * @precondition: game != null
	 * @postcondition: Game is added to completed list
	 * 
	 * @param game
	 *            game to be added to completed ArrayList
	 */
	public void addCompletedGame(Game game) {
		if (game == null) {
			throw new IllegalArgumentException("Game must exist");
		}
		if (this.inProgress.contains(game)) {
			this.inProgress.remove(game);
		}
		if (this.completed.contains(game)) {
			this.completed.remove(game);
		}
		if (!game.getCompletedStatus()) {
			game.setCompleteStatus(true);
		}

		this.completed.add(game);
	}

	/**
	 * Returns the list of completed games
	 * 
	 * @precondition: none
	 * @postconditions: none
	 * 
	 * @return the list of completed games
	 */
	public ArrayList<Game> getCompletedGames() {
		return this.completed;
	}

	/**
	 * Returns the list of in progress games
	 * 
	 * @precondition: none
	 * @postconditions: none
	 * 
	 * @return the list of in progress games
	 */
	public ArrayList<Game> getInProgressGames() {
		return this.inProgress;
	}

	/**
	 * Sets the list of inprogress games
	 * 
	 * @param games The list to set
	 */
	public void setInProgressGames(ArrayList<Game> games) {
		this.inProgress = games;
	}

	/**
	 * Returns the username of user
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return the username of user
	 */
	public String getUserName() {
		return this.username;
	}

	/** 
	 * Sets the username of the user
	 * 
	 * @precondition: username != null && username.isEmpty() != true
	 * @postcondition: username is set to param value
	 * 
	 * @param username
	 *            username of the user
	 */
	public void setUsername(String username) {
		if (username == null) {
			throw new IllegalArgumentException("Invalid username");
		}
		if (username.isEmpty()) {
			throw new IllegalArgumentException("Username not entered");
		}

		this.username = username;
	}

	/**
	 * returns the current game
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return the current game
	 */
	public Game getCurrentGame() {
		return this.currentGame;
	}

	/**
	 * Sets the current game
	 * 
	 * @precondition: currGame != null
	 * @postcondition: currentGame = currgame
	 * 
	 * @param currGame
	 *            current game of user
	 */
	public void setCurrentGame(Game currGame) {
		if (currGame == null) {
			throw new IllegalArgumentException("Current game must exist");
		}
		this.currentGame = currGame;
	}
}
