/**
 * 
 */
package edu.westga.cs3212.gamemanager.tests.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Player;

/**
 * @author Group2
 * @version Spring 2018
 *
 */
class TestGetPlayerName {
	private Player testPlayer;

	/**
	 * Sets up object for testing
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testPlayer = new Player("Krillin", 0);

	}

	@Test
	void testGetPlayerName() {
		assertEquals("Krillin", this.testPlayer.getPlayerName());
	}
}
