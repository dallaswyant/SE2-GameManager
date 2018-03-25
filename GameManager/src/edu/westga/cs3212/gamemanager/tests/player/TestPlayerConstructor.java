package edu.westga.cs3212.gamemanager.tests.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Player;

class TestPlayerConstructor {

	@Test
	void testPlayerValidConstructor() {
		Player player1 = new Player("Shaun", 5);
		
		assertEquals(player1.getPlayerName(), "Shaun");
		assertEquals(player1.getPlayerScore(), 5);
	}
	
	@Test
	public void testPlayerWithNullName() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Player player = new Player(null, 4);
			player.getPlayerName();
		});
		assertEquals("Invalid name", exception.getMessage());
	}
	
	@Test 
	public void testPlayerNameEmptysConstructor() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Player player = new Player("", 5);
			player.getPlayerName();
		});
		assertEquals("Name not entered", exception.getMessage());
	}
	
	@Test
	void testPlayerWithNegativePoints() {
		Player player1 = new Player("David", -50);
		assertEquals(player1.getPlayerScore(), -50);
	}
	
	
	

}
