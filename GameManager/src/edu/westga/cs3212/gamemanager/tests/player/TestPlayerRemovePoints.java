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
class TestPlayerRemovePoints {
	private Player testPlayer;

	/**
	 * Sets up object for testing.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testPlayer = new Player("Mr. Satan", 10);
	}

	@Test
	void testPlayerRemovePointsNegative() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testPlayer.removePoints(-3);
		});

		assertEquals("amount to remove must be > 0", exception.getMessage());
	}

	@Test
	void testPlayerRemovePointsWithZero() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testPlayer.removePoints(0);
		});

		assertEquals("amount to remove must be > 0", exception.getMessage());
	}

	@Test
	void testPlayerRemovePointsPositiveAmount() {
		this.testPlayer.removePoints(5);

		assertEquals(5, this.testPlayer.getPlayerScore());
	}
}
