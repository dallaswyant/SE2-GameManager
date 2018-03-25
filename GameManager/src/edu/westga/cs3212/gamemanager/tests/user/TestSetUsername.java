package edu.westga.cs3212.gamemanager.tests.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.User;

class TestSetUsername {
	@Test
	void testNullUsername() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			User user = new User(null);
			user.getUsername();
		});
		assertEquals("Invalid username", exception.getMessage());
	}
	
	@Test
	void testEmptyUserName() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			User user = new User("");
			user.getUsername();
		});
		assertEquals("Username not entered", exception.getMessage());
	}
	@Test
	void testValidUsername() {
		User user = new User("Bob's game");
		user.setUsername("My Game");
		assertEquals("My Game", user.getUsername());
	}

}
