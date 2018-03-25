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
class TestGetPlayerScore {
	private Player testPlayer;

	/**
	 * Sets up object for testing
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testPlayer = new Player("Goku", 9001);		
	}

	@Test
	void testGetPlayerScore() {
		assertEquals(9001, this.testPlayer.getPlayerScore());
	}

}
