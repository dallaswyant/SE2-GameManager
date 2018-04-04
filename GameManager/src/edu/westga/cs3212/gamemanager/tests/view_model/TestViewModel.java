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
import edu.westga.cs3212.gamemanager.model.User;
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
	
	@Test
	void testGMVMSetUser() {
		User dude = new User("Dude");
		this.testGMVM.setTheUser(dude);
		
		assertEquals(dude, this.testGMVM.getTheUser());
	}
	
	@Test
	void testGMVMSaveCurrentGameSuccess() {
		User dude = new User("Dude");
		ArrayList<Game> gameList = new ArrayList<Game>();
		gameList.add(new Game("Bacci Ball",15));
		gameList.add(new Game("Rocket League",10));
		gameList.add(new Game("Chess",2));
		
		dude.setInProgressGames(gameList);
		Game gameToSave = new Game("Chess",2);
		gameToSave.addPlayer(new Player("Goku",90));
		gameToSave.addPlayer(new Player("Bu",90));
		gameToSave.addPlayer(new Player("Piccolo",90));
		gameToSave.addPlayer(new Player("Krillin",90));
		dude.addInProgressGame(gameToSave);
		dude.setCurrentGame(gameToSave);
		this.testGMVM.setTheUser(dude);
		this.testGMVM.saveCurrentGame();
		assertEquals(gameToSave.toString(),dude.getCurrentGame().toString());
		assertEquals(4, dude.getInProgressGames().size());
		assertEquals(4, dude.getCurrentGame().getNumberOfPlayers());
		
	}
}

