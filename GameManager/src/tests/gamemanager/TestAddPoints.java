package tests.gamemanager;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Player;

class TestAddPoints {
	
	@Test  
	void testAddNegativePointsWithInitialOfZero() {
		Player player1 = new Player("Tommy", 0);
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			player1.addPoints(-15);
		});
	
		assertEquals("amount to add must be >= 0", exception.getMessage());
	}
	
	@Test 
	void testAddNegativePointsWithInitialOfTen() {
		Player player1 = new Player("Tommy", 10);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			player1.addPoints(-15);
		});
		
		assertEquals("amount to add must be >= 0", exception.getMessage());
	}

	@Test
	void testAddPointsWithInitialOfZero() {
		Player player1 = new Player("Tommy", 0);
		player1.addPoints(50);
		assertEquals(player1.getPoints(), 50);
	}
	
	@Test
	void testAddPointsWithInitialOfTen() {
		Player player1 = new Player("Tommy", 10);
		player1.addPoints(50);
		assertEquals(player1.getPoints(), 60);
	}
	
	@Test
	void testAddPointsWithInitialOfNegativeNum() {
		Player player1 = new Player("Tommy", -50);
		player1.addPoints(50);
		assertEquals(player1.getPoints(), 0);
	}

}
