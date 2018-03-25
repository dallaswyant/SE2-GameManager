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
 * @version Spring2018
 *
 */
class TestUserAddInProgressGame {
	private User testUser;
	private Game testGame;
	private Game testGame2;

	/**
	 * Sets up object for testing
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testUser = new User("Same Time");
		this.testGame = new Game("Halo");
		this.testGame2 = new Game("PUBG");
	}

	@Test
	void testUserAddInProgressGameNull() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testUser.addInProgressGame(null);
		});

		assertEquals("Game must exist", exception.getMessage());
	}

	@Test
	void testUserAddInProgressGameWithInProgressAlreadyExisting() {
		this.testUser.addInProgressGame(this.testGame);
		this.testUser.addInProgressGame(this.testGame);

		assertEquals(1, this.testUser.getInProgressGames().size());
	}

	@Test
	void testUserAddInProgressGameWithGameCompletedAlreadyExisting() {
		this.testUser.addCompletedGame(testGame);
		this.testUser.addInProgressGame(testGame);

		assertEquals(0, this.testUser.getCompletedGames().size());
		assertEquals(1, this.testUser.getInProgressGames().size());
	}

	@Test
	void testUserAddInProgressGameWithGameStatusCompleted() {
		this.testGame.setCompleteStatus(true);

		this.testUser.addInProgressGame(testGame);

		assertFalse(this.testGame.getCompletedStatus());
		assertEquals(1, this.testUser.getInProgressGames().size());
	}

	@Test
	void testUserAddInProgressGameWithIncompleteGame() {
		this.testUser.addInProgressGame(testGame);

		assertEquals(1, this.testUser.getInProgressGames().size());
	}

	@Test
	void testUserAddInProgressGameWith2Games() {
		this.testUser.addInProgressGame(testGame);
		this.testUser.addInProgressGame(testGame2);

		assertEquals(2, this.testUser.getInProgressGames().size());
	}

}
