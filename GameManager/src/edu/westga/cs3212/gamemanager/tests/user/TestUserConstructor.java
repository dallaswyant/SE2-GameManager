package edu.westga.cs3212.gamemanager.tests.user;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.User;

class TestUserConstructor {
	
	@Test
	void testUserConstructorWithNull() {		
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			User testUser = new User(null);
		});
		
		assertEquals("Invalid username", exception.getMessage());
	}
	
	@Test
	void testUserConstructorWithEmptyString() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			User testUser = new User("");
		});
		
		assertEquals("Username not entered", exception.getMessage());	
	}
	
	@Test
	void testUserConstructorValid() {
		User testUser = new User("Master Cheif");
		
		assertEquals(testUser, testUser);
	}
}