package edu.westga.cs3212.gameTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;

public class TestGameRemovePlayer {
	
	@Test 
	void testRemoveUnexistingPlayer() {
		Game game = new Game("game");
		Player p1 = new Player("Jack", 40);
		Player p2 = new Player("Timmy",30 );
		game.addPlayer(p1);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			game.removePlayer(p2);
		});
		assertEquals("ArrayList must contain player", exception.getMessage());
	}

	@Test
	void testRemovePlayer() {
		Game game = new Game("game1");
		Player p1 = new Player("Tim", 50);
		game.addPlayer(p1);
		game.removePlayer(p1);
		assertEquals(0, game.getNumberOfPlayers());
	}
	
	@Test
	void testRemoveOneFromMultiPlayers() {
		Game game = new Game("game1");
		Player p1 = new Player("Tim", 50);
		Player p2 = new Player("Jack", 40);
		Player p3 = new Player("Doug", 30);
		
		game.addPlayer(p1);
		game.addPlayer(p2);
		game.addPlayer(p3);
		game.removePlayer(p3);
		
		assertEquals(2, game.getNumberOfPlayers());
	}

}
