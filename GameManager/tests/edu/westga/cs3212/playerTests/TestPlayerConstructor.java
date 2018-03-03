package edu.westga.cs3212.playerTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Player;

class TestPlayerConstructor {

	@Test
	void testPlayerValidConstructor() {
		Player player1 = new Player("Shaun", 5);
		
		assertEquals(player1.getName(), "Shaun");
		assertEquals(player1.getPoints(), 5);
	}
	
	@Test
	public void testPlayerWithNullName() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Player player = new Player(null, 4);
		});
		assertEquals("Invalid name", exception.getMessage());
	}
	
	@Test 
	public void testPlayerNameEmptysConstructor() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Player player = new Player("", 5);
		});
		assertEquals("Name not entered", exception.getMessage());
	}
	
	@Test
	void testPlayerWithNegativePoints() {
		Player player1 = new Player("David", -50);
		assertEquals(player1.getPoints(), -50);
	}
	
	
	

}
