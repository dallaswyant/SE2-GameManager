/**
 * 
 */
package edu.westga.cs3212.gamemanager.tests.view_model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3212.gamemanager.model.Game;
import edu.westga.cs3212.gamemanager.model.Player;
import edu.westga.cs3212.gamemanager.view_model.GameManagerViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Group 2
 * @version Spring 2018
 *
 */
class TestViewModel {
	private GameManagerViewModel testGMVM;

	/**
	 * Sets up objects for testing
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testGMVM = new GameManagerViewModel();
	}

	@Test
	void testGMVMConstructor() {
		assertEquals(this.testGMVM, this.testGMVM);
	}

	@Test
	void testGMVMClearPlayers() {
		this.testGMVM.clearPlayersInCurrentGame();

		assertEquals(0, this.testGMVM.getPlayersInCurrentGame().size());
	}

	@Test
	void testGMVMGetCompletedGames() {
		assertEquals(10, this.testGMVM.getCompletedGames().size());
	}

	@Test
	void testGMVMSetPlayersInCurrentGameWithNull() {
		ObservableList<Player> testList = null;

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testGMVM.setPlayersInCurrentGame(testList);
		});
		assertEquals("List must exist", exception.getMessage());
	}

	@Test
	void testGMVMSetPlayersInCurrentGame() {
		ArrayList<Player> testArray = new ArrayList<Player>();
		testArray.add(new Player("Goku", 9001));
		testArray.add(new Player("Gohan", 1000));
		ObservableList<Player> testList = FXCollections.observableList(testArray);

		this.testGMVM.setPlayersInCurrentGame(testList);

		assertEquals(2, this.testGMVM.getPlayersInCurrentGame().size());
	}

	@Test
	void testGMVMGetInProgressGames() {
		assertEquals(10, this.testGMVM.getInProgressGames().size());
	}

	@Test
	void testGMVMGetTheUser() {
		assertEquals("Name", this.testGMVM.getTheUser().getUserName());
	}

	@Test
	void testGMVMAddPlayersToCurrentGameWithNull() {
		Player testPlayer = null;
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			this.testGMVM.addPlayersToCurrentGame(testPlayer);
		});
		assertEquals("Player is null", exception.getMessage());
	}

	@Test
	void testGMVMAddPlayersToCurrentGame() {
		Player testPlayer = new Player("Goku", 9001);
		this.testGMVM.addPlayersToCurrentGame(testPlayer);

		assertEquals(1, this.testGMVM.getPlayersInCurrentGame().size());
	}
}
