/**
 * 
 */
package edu.westga.cs3212.gamemanager.tests.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Player;
import edu.westga.cs3212.gamemanager.model.User;

/**
 * @author Group 2
 * @version Spring 2018
 *
 */
class TestSetPlayerName {
	private Player testPlayer;

	/**
	 * Sets up object for testing
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testPlayer = new Player("DumbFace", 100);
	}

	@Test
	void testSetPlayerName() {
		this.testPlayer.setPlayerName("Piccolo");

		assertEquals("Piccolo", this.testPlayer.getPlayerName());
	}

	@Test
	void testSetPlayerNameWithNull() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testPlayer.setPlayerName(null);
		});
		assertEquals("Invalid name", exception.getMessage());
	}

	@Test
	void testSetPlayerNameWithEmptyString() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testPlayer.setPlayerName("");
		});
		assertEquals("Name not entered", exception.getMessage());
	}
}
