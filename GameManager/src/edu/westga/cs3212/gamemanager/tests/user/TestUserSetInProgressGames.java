/**
 * 
 */
package edu.westga.cs3212.gamemanager.tests.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.User;

/**
 * @author Group 2
 * @version Spring 2018
 *
 */
class TestUserSetInProgressGames {
	private User testUser;
	private ArrayList<Game> testList;

	/**
	 * Sets up objects for testing.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testUser = new User("Josh");
		this.testList = new ArrayList<Game>();

		this.testList.add(new Game("Halo"));
		this.testList.add(new Game("PUBG"));
	}

	@Test
	void testUserSetInProgressGames() {
		this.testUser.setInProgressGames(this.testList);
		assertEquals(2, this.testUser.getInProgressGames().size());
	}

}
