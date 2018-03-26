package edu.westga.cs3212.gamemanager.tests.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.User;

/**
 * 
 * @author Group 2
 * @version Spring 2018
 *
 */
class TestUserSetUserName {
	private User testUser;

	/**
	 * Sets up object for testing
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testUser = new User("Josh");
	}

	@Test
	void testUserSetUserNameNull() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testUser.setUsername(null);
		});
		assertEquals("Invalid username", exception.getMessage());
	}

	@Test
	void testUserSetUserNameEmptyString() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testUser.setUsername("");
		});
		assertEquals("Username not entered", exception.getMessage());
	}

	@Test
	void testUserSetUserNameValid() {
		this.testUser.setUsername("Green Ranger");

		assertEquals("Green Ranger", this.testUser.getUserName());
	}

}
