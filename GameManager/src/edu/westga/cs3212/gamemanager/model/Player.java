package edu.westga.cs3212.gamemanager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The player class.
 * 
 * @author Bryan, Caleb, Josh, Dallas
 * @version 2/13/18
 *
 */
public class Player {

	private int points;
	private String name;
	private IntegerProperty playerScore;
    private StringProperty playerName;

	/**
	 * Player constructor
	 * 
	 * @preconditions: name != null && name.isEmpty() != true
	 * @postcondition: this.points is set to points && this.name is set to name
	 * 
	 * @param name
	 *            name of the player
	 * @param points
	 *            points of the player
	 */
	public Player(String name, int points) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name not entered");
		}

		this.name = name;
		this.points = points;
		this.playerName = new SimpleStringProperty(name);
		this.playerScore = new SimpleIntegerProperty(points);

	}

	public Integer getPlayerScore() {
		return this.playerScore.get();
	}

	public String getPlayerName() {
		return this.playerName.get();
	}

	public void setPlayerScore(int score) {
		this.playerScore.set(score);
	}

	public void setPlayerName(String name) {
		this.playerName.set(name);
	}



	/**
	 * Gets the points the player has
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return points the player has
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * sets the players points
	 * 
	 * @precondition: none
	 * @postcondition: points are set to param value
	 * 
	 * @param points
	 *            points the player will have
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * gets the name of the player
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the player to param value
	 * 
	 * @precondition: name !=null && name.isEmpty() != true
	 * @postcondition: name is set to param value
	 * @param name
	 *            name of the player
	 */
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name not entered");
		}
		this.name = name;
	}

	/**
	 * Adds amount to player points
	 * 
	 * @precondition: amount >= 0
	 * @postcondition: points value increased by amount
	 * 
	 * @param amount
	 *            amount of points to be added
	 */
	public void addPoints(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("amount to add must be >= 0");
		}
		this.points = this.getPoints() + amount;
	}

	/**
	 * Removes amount to player points
	 * 
	 * @precondition: amount <= 0
	 * @postcondition: points value increased by amount
	 * 
	 * @param amount
	 *            amount of points to be remove
	 */
	public void removePoints(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("amount to add must be <= 0");
		}
		this.points = this.getPoints() - amount;
	}
	
	public String toString() {
		return this.name + "   " + this.points + "pts";
	}

}
