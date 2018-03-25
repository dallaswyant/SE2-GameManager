package edu.westga.cs3212.gamemanager.tests.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;

class TestGameAddPlayer {
	
	@Test
	void testAddNullPlayers() {
		Game game = new Game("game1");
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->{
			game.addPlayer(null);
		});
		assertEquals("Player must exist to be added", exception.getMessage());
	}

	@Test
	void testAddPlayer() {
		Game game = new Game("game1");
		Player p1 = new Player("Tim", 50);
		game.addPlayer(p1);
		assertEquals(1, game.getNumberOfPlayers());
	}
	
	@Test
	void testAddMultiPlayers() {
		Game game = new Game("game1");
		Player p1 = new Player("Tim", 50);
		Player p2 = new Player("Jack", 40);
		Player p3 = new Player("Doug", 30);
		
		game.addPlayer(p1);
		game.addPlayer(p2);
		game.addPlayer(p3);
		
		assertEquals(3, game.getNumberOfPlayers());
	}

}
