package edu.westga.cs3212.gamemanager.tests.user;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.User;

class TestUserConstructor {
	
	@Test 
	public void testUserNullConstructor() {
		
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			User user = new User(null);
			user.getUsername();
		});
		assertEquals("Invalid username", exception.getMessage());
	}
	
	@Test
	public void testUserEmptyConstructor() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			User user = new User("");
			user.getUsername();
		});
		assertEquals("Username not entered", exception.getMessage());
	
	}
	
	
	
	
	void testUserValidConstructor() {
		Game game = new Game("Game1");
		Game game2 = new Game("Game2");
		User user1 = new User("Django");
		user1.addCompletedGame(game);
		user1.addInProgressGame(game2);
		
		assertEquals(user1.getUsername(), "Django");
	}
	

}
