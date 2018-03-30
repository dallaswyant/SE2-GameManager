package edu.westga.cs3212.gamemanager.model;

import java.util.Comparator;

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
public class Player implements Comparable<Player> {

	private IntegerProperty playerScore;
	private StringProperty playerName;
	private StringProperty toString;

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

		this.playerName = new SimpleStringProperty(name);
		this.playerScore = new SimpleIntegerProperty(points);
		this.toString = new SimpleStringProperty(name + "   " + points + "pts");

	}

	/**
	 * Returns the players score
	 * 
	 * @return The score of the player
	 */
	public Integer getPlayerScore() {
		return this.playerScore.get();
	}

	/**
	 * Returns the players name
	 * 
	 * @return The name of the player
	 */
	public String getPlayerName() {
		return this.playerName.get();
	}

	/**
	 * Sets the players score
	 * 
	 * @param score
	 *            The score to set
	 */
	public void setPlayerScore(int score) {
		this.playerScore.set(score);
	}

	/**
	 * Sets the players name
	 * 
	 * @param name
	 *            The name to set
	 */
	public void setPlayerName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name not entered");
		}
		this.playerName.set(name);
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
		if (amount <= 0) {
			throw new IllegalArgumentException("amount to add must be > 0");
		}
		this.playerScore.set(this.playerScore.get() + amount);
	}

	/**
	 * Removes amount to player points
	 * 
	 * @precondition: amount <= 0
	 * @postcondition: points value decreased by amount
	 * 
	 * @param amount
	 *            amount of points to be removed
	 */
	public void removePoints(int amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount to remove must be > 0");
		}
		this.playerScore.set(this.playerScore.get() - amount);
	}

	/**
	 * Returns a string representation of the object
	 * 
	 * @return A string describing the object
	 */
	public String toString() {
		return this.playerName.get() + " " + this.playerScore.get() + "pts";
	}

	@Override
	public int compareTo(Player arg0) {
		return this.playerScore.get() - arg0.playerScore.get();
	}

	public static Comparator<Player> PlayerComparator = new Comparator<Player>() {
		public int compare(Player person, Player anotherPerson) {
			int points = person.playerScore.get();
			int points2 = anotherPerson.playerScore.get();
			return points2 - points;

		};
	};
}
