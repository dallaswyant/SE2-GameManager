package tests.gamemanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Player;

class TestSetName {
	
	@Test 
	public void testSetNameIfNull() {
		Player player1 = new Player("Craig", 32);
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->{
			player1.setName(null);
		});
		
		
		assertEquals("Invalid name", exception.getMessage());
	}
	
	@Test
	public void testSetNameIfEmpty() {
		Player player1 = new Player("Seth Rogen", 69);
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			player1.setName("");
		});
		
		
		assertEquals("Name not entered", exception.getMessage());
		
	}

	@Test
	void testSetNameDiffThanOriginal() {
		Player player1 = new Player("Dave", 50);
		player1.setName("Craig");
		assertEquals(player1.getName(), "Craig");
	}
	
	@Test
	void testSetNameSameAsOriginal() {
		Player player1 = new Player("Dave",32);
		player1.setName("Dave");
		assertEquals(player1.getName(), "Dave");
	}
	
	

}
