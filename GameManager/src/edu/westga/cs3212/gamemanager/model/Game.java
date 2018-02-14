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

		this.players = new ArrayList<Player>();
		name = this.name;
		// I have set to false so each game starts as a new
		this.isCompleted = false;

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
		if (status == true) {
			this.isCompleted = true;
		} else {
			this.isCompleted = false;
		}
	}

}
