package edu.westga.cs3212.userTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.User;

class TestSetCurrentGame {
	
	@Test
	void testNullUsername() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			User user = new User(null);
			user.getUsername();
		});
		assertEquals("Invalid username", exception.getMessage());
	}
	
	@Test
	void testEmptyUsername() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			User user = new User("");
			user.getUsername();
		});
		assertEquals("Username not entered", exception.getMessage());
	}
	
	@Test
	void testSetValidGame() {
		User user = new User("My Games");
		user.setUsername("Game 1");
		assertEquals("Game 1", user.getUsername());
	}
	

}
