package edu.westga.cs3212.gamemanager.tests.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;

class TestGameConstructor {

	@Test
	void testGameConstructorNull() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Game testGame = new Game(null);
		});
		assertEquals("Invalid game name", exception.getMessage());
	}

	@Test
	void testGameConstructorEmptyString() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Game testGame = new Game("");
		});
		assertEquals("Game name not entered", exception.getMessage());
	}

	@Test
	void testGameConstructorWithValidName() {
		Game testGame = new Game("Spades");

		assertEquals(testGame, testGame);
	}

	@Test
	void testGameOverloadedConstructorWithNull() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Game testGame = new Game(null, 2);
		});
		assertEquals("Invalid game name", exception.getMessage());
	}

	@Test
	void testGameOverloadedConstructorWithEmptyString() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Game testGame = new Game("", 2);
		});
		assertEquals("Game name not entered", exception.getMessage());
	}

	@Test
	void testGameOverloadedConstructorWithZeroPointIncrement() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Game testGame = new Game("Game", 0);
		});
		assertEquals("Cannot have zero/negative point increment value", exception.getMessage());
	}

	@Test
	void testGameOverloadedConstructorWithNegativePointIncrement() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			Game testGame = new Game("Game", -5);
		});
		assertEquals("Cannot have zero/negative point increment value", exception.getMessage());
	}

	@Test
	void testGameOverloadedConstructorWithValidInput() {
		Game testGame = new Game("Halo", 100);

		assertEquals(testGame, testGame);
	}
}
