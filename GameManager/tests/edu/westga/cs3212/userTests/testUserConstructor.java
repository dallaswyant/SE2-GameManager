package edu.westga.cs3212.userTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;
import edu.westga.cs3212.gamemanager.model.User;

class testUserConstructor {
	
	@Test 
	public void testUserNullConstructor() {
		
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			User user = new User(null);
		});
		assertEquals("Invalid username", exception.getMessage());
	}
	
	@Test
	public void testUserEmptyConstructor() {
		
		try {
			User user = new User("");
			fail("Illegal");
		} catch(IllegalArgumentException e) {
			assertEquals("Username not entered", e.getMessage());
		}
	
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
