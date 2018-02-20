package edu.westga.cs3212.gamemanager.model;

import java.util.ArrayList;

/**
 * The game class.
 * 
 * @author Bryan, Caleb, Josh, Dallas
 * @version 2/13/18
 *
 */
public class Game {
	private ArrayList<Player> players;
	private Boolean isCompleted;
	private String name;
	private int pointIncrementValue;

	/**
	 * Constructor for Game class
	 * 
	 * @preconditions: name != null && name.isEmpty() != true
	 * @postconditions: this.name = name && this.isCompleted = false
	 * 
	 * @param name
	 *            name of the game
	 */
	public Game(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid game name");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Game name not entered");

		}
		this.pointIncrementValue = 1;
		this.players = new ArrayList<Player>();
		this.name = name;
		this.isCompleted = false;

	}

	/**
	 * Constructor for Game class
	 * 
	 * @preconditions: name != null && name.isEmpty() != true
	 * @postconditions: this.name = name && this.isCompleted = false
	 * 
	 * @param name
	 *            name of the game
	 * @param pointIncrementValue
	 *            the number by which we will increment/decrement points
	 */
	public Game(String name, int pointIncrementValue) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid game name");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Game name not entered");
		}
		if (pointIncrementValue < 1) {
			throw new IllegalArgumentException("Cannot have negative point increment value");
		}
		this.players = new ArrayList<Player>();
		this.name = name;
		this.isCompleted = false;
		this.pointIncrementValue = pointIncrementValue;
	}

	/**
	 * Adds a player to the this.players ArrayList
	 * 
	 * @precondition: player != null
	 * @postcondition: player is added to players ArrayList
	 * 
	 * @param player
	 *            player to be added to ArrayList
	 */
	public void addPlayer(Player player) {
		if (player == null) {
			throw new IllegalArgumentException("Player must exist to be added");
		}
		this.players.add(player);
	}

	/**
	 * Removes a player from ArrayList
	 * 
	 * @precondition: this.players.contains(player) != false
	 * @postcondition: player is removed from the players ArrayList
	 * 
	 * @param player
	 *            player to be removed from ArrayList
	 */
	public void removePlayer(Player player) {
		if (!this.players.contains(player)) {
			throw new IllegalArgumentException("ArrayList must contain player");
		}
		this.players.remove(player);
	}

	/**
	 * Gets the number of players in ArrayList players.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return the number of players in the players ArrayList
	 */
	public int getNumberOfPlayers() {
		return this.players.size();
	}

	/**
	 * Returns true or false if status is completed
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return returns true or false based on status.
	 */
	public Boolean getCompletedStatus() {
		return this.isCompleted;
	}

	/**
	 * Sets the status to either true or false
	 * 
	 * @precondition: none
	 * @postcondition: status is set to parameter value of true or false.
	 * 
	 * @param status
	 *            the status
	 */
	public void setCompleteStatus(Boolean status) {
		this.isCompleted = status;
	}

	/**
	 * Returns a string representation of the object.
	 * 
	 * @return A string describing the object.
	 */
	public String toString() {
		return this.name;
	}

	/**
	 * Returns the list of players.
	 * 
	 * @return The list of players.
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * Returns the current point increment value.
	 * 
	 * @return Current point increment value.
	 */
	public int getPointIncrementValue() {
		return this.pointIncrementValue;
	}

}
