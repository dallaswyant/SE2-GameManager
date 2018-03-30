/**
 * 
 */
package edu.westga.cs3212.gamemanager.tests.player;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Player;

/**
 * @author Group 2
 * @version Spring 2018
 *
 */
class TestPlayerAddPoints {
	private Player testPlayer;

	/**
	 * Sets up object for testing
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testPlayer = new Player("Buu", 5);
	}

	@Test
	void testPlayerAddPointsNegative() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testPlayer.addPoints(-5);
		});

		assertEquals("amount to add must be > 0", exception.getMessage());
	}

	@Test
	void testPlayerAddPointsAddingZero() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testPlayer.addPoints(0);
		});

		assertEquals("amount to add must be > 0", exception.getMessage());
	}

	@Test
	void testPlayerAddPointsPositiveAmount() {
		this.testPlayer.addPoints(10);
		int score = this.testPlayer.getPlayerScore();
		assertEquals(15, score);
	}
}
