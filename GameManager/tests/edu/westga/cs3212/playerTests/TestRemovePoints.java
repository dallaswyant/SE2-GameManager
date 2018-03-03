package edu.westga.cs3212.playerTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Player;

class TestRemovePoints {


	
	@Test
	public void testNegativePointsRemoval() {
		Player player = new Player("Jimmy", 10);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			player.removePoints(-5);
		});
		assertEquals("amount to add must be <= 0", exception.getMessage());
	}
	

	@Test
	void testRemovePointsWithInitialOfZero() {
		Player player1 = new Player("Tommy", 0);
		player1.removePoints(20);
		assertEquals(player1.getPoints(), -20);
	}
	
	@Test
	void testRemoveZeroPoints() {
		Player player1 = new Player("Tommy", 50);
		player1.removePoints(0);
		assertEquals(player1.getPoints(), 50);
	}
	
	
	@Test
	void testRemovePointsWithInitialOfTen() {
		Player player1 = new Player("Tommy", 10);
		player1.removePoints(5);
		assertEquals(player1.getPoints(), 5);
	}
	
	@Test
	void testRemovePointsWithInitialOfNegativeNum() {
		Player player1 = new Player("Tommy", -50);
		player1.removePoints(50);
		assertEquals(player1.getPoints(), -100);
	}
	
	


}
