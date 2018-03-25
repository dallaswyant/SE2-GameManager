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
class TestPlayerCompareTo {
	private Player testPlayer;
	private Player testPlayer2;

	/**
	 * Sets up object for testing.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testPlayer = new Player("Vegeta", 100);
		this.testPlayer2 = new Player("Trunks", 75);
	}

	@Test
	void testCompareToPlayers() {
		assertEquals(25, this.testPlayer.compareTo(this.testPlayer2));
	}

	@Test
	void testCompareToPlayersReverse() {
		assertEquals(-25, this.testPlayer2.compareTo(this.testPlayer));
	}
}
