package tests.gamemanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;

class TestGameConstructor {

	@Test
	void testNullGameConstructor() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Game game = new Game(null);
			game.getCompletedStatus();
		});
		assertEquals("Invalid game name", exception.getMessage());
	}
	
	@Test
	void testEmptyGameConstructor() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Game game = new Game("");
			game.getCompletedStatus();
		});
		assertEquals("Game name not entered", exception.getMessage());
	}
	
	@Test
	void testGameValidWithNoPlayers() {
		Game game1 = new Game("Game1");
		
		
		assertEquals(0, game1.getNumberOfPlayers());
		assertFalse(game1.getCompletedStatus());
		
	}
	
	@Test
	void testGameValidWithOnePlayer() {
		Game game1 = new Game("Game1");
		Player player1 = new Player("p1", 50);
		game1.addPlayer(player1);
		assertEquals(1, game1.getNumberOfPlayers());
		assertFalse(game1.getCompletedStatus());
		
	}
	
	@Test
	void testGameValidMultiPlayers() {
		Game game1 = new Game("Game1");
		Player player1 = new Player("p1", 50);
		Player p2 = new Player("p2", 60);
		Player p3 = new Player("p3", 70);
	
		game1.addPlayer(player1);
		game1.addPlayer(p2);
		game1.addPlayer(p3);
		assertEquals(3, game1.getNumberOfPlayers());
		assertFalse(game1.getCompletedStatus());
		
	}
	
	

}
