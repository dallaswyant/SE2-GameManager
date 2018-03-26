/**
 * 
 */
package edu.westga.cs3212.gamemanager.tests.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;

/**
 * @author Group 2
 * @version Spring 2018
 *
 */
class TestGameGetPointIncrementValue {
	private Game testGame;

	/**
	 * Sets up object for testing
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testGame = new Game("Rocket League", 1);
	}

	@Test
	void testGameGetPointIncrementValue() {
		assertEquals(1, this.testGame.getPointIncrementValue());
	}

}
