/**
 * 
 */
package edu.westga.cs3212.gamemanager.tests.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Player;

/**
 * @author Group 2
 * @version Spring 2018
 *
 */
class TestSetPlayerScore {
	private Player testPlayer;

	/**
	 * Sets up object for testing
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testPlayer = new Player("Gohan", 20);
	}

	@Test
	void testSetPlayerScore() {
		this.testPlayer.setPlayerScore(100);
		
		assertEquals(100, (int)this.testPlayer.getPlayerScore());
	}

}
