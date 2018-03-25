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

	private int points;
	private String name;
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

		this.name = name;
		this.points = points;
		this.playerName = new SimpleStringProperty(name);
		this.playerScore = new SimpleIntegerProperty(points);
		this.toString = new SimpleStringProperty(name + "   " + points + "pts");

	}

	/**
	 * Sets the player objects score to the specified score.
	 * 
	 * @param score
	 *            The score to set.
	 */
	public void setPlayerScore(int score) {
		this.points = score;
		this.playerScore.set(score);
	}

	/**
	 * Sets the player objects name to the specified name.
	 * 
	 * @precondition: name !=null && name.isEmpty() != true
	 * @postcondition: name is set to param value
	 * @param name
	 *            name of the player
	 * @param name
	 *            The name to set.
	 */
	public void setPlayerName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name not entered");
		}
		this.name = name;
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
	public int getPlayerScore() {
		return this.points;
	}

	/**
	 * gets the name of the player
	 * 
	 * @precondition: none
	 * @postcondition: none
	 * 
	 * @return the name of the player
	 */
	public String getPlayerName() {
		return this.name;
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
		this.points = this.getPlayerScore() + amount;
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
		this.points = this.getPlayerScore() - amount;
	}

	public String toString() {
		return this.name + "   " + this.points + "pts";
	}

	@Override
	public int compareTo(Player arg0) {
		return this.getPlayerScore() - arg0.getPlayerScore();
	}

	public static Comparator<Player> PlayerComparator = new Comparator<Player>() {
		public int compare(Player person, Player anotherPerson) {
			int points = person.getPlayerScore();
			int points2 = anotherPerson.getPlayerScore();
			return points2 - points;

		};
	};
}
