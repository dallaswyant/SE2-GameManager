/**
 * 
 */
package edu.westga.cs3212.gamemanager.tests.user;

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
class TestUserGetCompletedGames {
	private User testUser;
	private Game testGame;
	private Game testGame2;
	private Game testGame3;

	/**
	 * Sets up object for testing
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testUser = new User("Josh");

		this.testGame = new Game("Spades");
		this.testGame.setCompleteStatus(true);
		this.testGame2 = new Game("Monopoly");
		this.testGame2.setCompleteStatus(true);
		this.testGame3 = new Game("Solitare");
		this.testGame3.setCompleteStatus(true);

		this.testUser.addCompletedGame(testGame);
		this.testUser.addCompletedGame(testGame2);
		this.testUser.addCompletedGame(testGame3);
	}

	@Test
	void testUserGetCompletedGames() {
		assertEquals(3, this.testUser.getCompletedGames().size());
	}

}
