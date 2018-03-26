/**
 * 
 */
package edu.westga.cs3212.gamemanager.tests.user;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.User;

/**
 * @author Group 2
 * @version Spring 2018
 *
 */
class TestUserSetCurrentGame {
	private User testUser;
	private Game testGame;

	/**
	 * Sets up objects for testing
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testUser = new User("Joshua");
		this.testGame = new Game("DBZ");
	}

	@Test
	void testUserSetCurrentGameWithNull() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testUser.setCurrentGame(null);
		});

		assertEquals("Current game must exist", exception.getMessage());
	}

	@Test
	void testUserSetCurrentGameWithValid() {
		this.testUser.setCurrentGame(this.testGame);

		assertEquals("DBZ", this.testUser.getCurrentGame().toString());
	}

}
