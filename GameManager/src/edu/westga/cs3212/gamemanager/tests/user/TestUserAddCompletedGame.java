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
class TestUserAddCompletedGame {
	private User testUser;
	private Game testGame;
	private Game testGame2;

	/**
	 * Sets up objects for testing.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testUser = new User("Same Time");
		this.testGame = new Game("Halo");
		this.testGame.setCompleteStatus(true);
		this.testGame2 = new Game("PUBG");
	}

	@Test
	void testUserAddCompletedGameNull() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testUser.addCompletedGame(null);
		});

		assertEquals("Game must exist", exception.getMessage());
	}

	@Test
	void testUserAddCompletedGameWithInProgressAlreadyExisting() {
		this.testUser.addInProgressGame(this.testGame2);
		this.testUser.addCompletedGame(this.testGame2);

		assertEquals(1, this.testUser.getCompletedGames().size());
		assertEquals(0, this.testUser.getInProgressGames().size());
	}

	@Test
	void testUserAddCompletedGameWithGameCompletedAlreadyExisting() {
		this.testUser.addCompletedGame(testGame);
		this.testUser.addCompletedGame(testGame);

		assertEquals(1, this.testUser.getCompletedGames().size());
	}

	@Test
	void testUserAddCompletedGameWithGameStatusUncompleted() {
		this.testUser.addCompletedGame(testGame2);

		assertTrue(this.testGame2.getCompletedStatus());
		assertEquals(1, this.testUser.getCompletedGames().size());
	}

	@Test
	void testUserAddCompletedGameWithCompleteGame() {
		this.testUser.addCompletedGame(testGame);

		assertEquals(1, this.testUser.getCompletedGames().size());
	}

	@Test
	void testUserAddCompletedGameWith2CompleteGames() {
		this.testUser.addCompletedGame(testGame);
		this.testGame2.setCompleteStatus(true);
		this.testUser.addCompletedGame(testGame2);

		assertEquals(2, this.testUser.getCompletedGames().size());
	}

}
